package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.Users;

@Repository
@Transactional(isolation=Isolation.DEFAULT,rollbackFor = Exception.class)
public class RegisterDaoImp extends
		org.springframework.orm.jpa.support.JpaDaoSupport implements
		RegisterDAO {
	private static final String DETAIL = "DETAIL";
	private static final long AUTO = -2;	

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW,isolation=Isolation.DEFAULT)
	public Users save(Node1 n,Long id,String provinceId) throws DataAccessException{		
		try {			
			id = getID(id);
			n.getUser().setUserId(Generate.getId(id, provinceId));
			n.getUser().setNode1(n);
			n.setNId(id);			
			getJpaTemplate().persist(n);		
		} catch (Exception e) {			
			log.error(e.getMessage(),e);			
		}
		return n.getUser();
	}
	@Transactional(readOnly=false,isolation=Isolation.SERIALIZABLE)
	public Long getID(Long id){
		NodeDescription d = null;
		d =getDescription();
		boolean b= false;
		if(id==AUTO){id = d.getNextId();b=true;};		
		while(getUserFromId(id)!=null)id++;	
		int c = d.getCount();		
		int mx = d.getMaxNode();
		if (++c == mx) {
			c=0;
			int level = Generate.log2(id+1);			
			d.setMaxNode((int)Generate.math2Pow(level));
			d.setUpper(Generate.math2Pow(level+1)-1);
		}		
		if(b)d.setNextId(id+1);
		d.setCount(c);	
		return id;
	}
	@Transactional(readOnly=true)
	private Node1 getUserFromId(Long id)throws NullPointerException{
		return getJpaTemplate().find(Node1.class,id);
	}
	@Transactional(readOnly=true)
	public NodeDescription getDescription(){
		NodeDescription d = null;
		try{
			d = getJpaTemplate().find( 
				NodeDescription.class, DETAIL);	
			}catch (Exception e) {
				log.error(e.getMessage(),e);
		}
		return d;	
	}	
	private static Logger log = Logger.getLogger(RegisterDaoImp.class);
}