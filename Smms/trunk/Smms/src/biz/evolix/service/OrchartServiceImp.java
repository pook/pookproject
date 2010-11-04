package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.dao.Node1DAO;

public class OrchartServiceImp implements OrchartService {

	//private List<Node1> teams = new ArrayList<Node1>();
	private Long header = -1L;
	private Long currentHeader;
	@Autowired
	private Node1DAO node1DAO;

	public List<Node1> getTeamLevel(Long id) {
		List<Node1> teams = new ArrayList<Node1>();
		Long c = 1L, l = 1L, r = -1L;
		Node1 n = null;
		try {
			n = node1DAO.getNode1(id);
		} catch (NullPointerException e) {
			System.err.println(e);
		}
		if(n==null)return null;
		teams = new ArrayList<Node1>();		
		teams.add(n);	
		for (int i = 0; i < 16; i++) {
			Node1 n1 = null, n2 = null;
			try {
				c = teams.get(i).getNId();
			} catch (Exception e) {
				System.err.println(e+"1");
				break;
			}
			l = Generate.getLeftChildId(c);			
			try {
				n1 = node1DAO.getNode1(l);

			} catch (Exception e) {
				System.err.println(e);
			}
			if (n1 != null)
				teams.add(teams.size(), n1);
			r = Generate.getRightChildId(c);
			System.out.println("xx"+r);
			try {
				n2 = node1DAO.getNode1(r);
			} catch (Exception e) {
				System.err.println(e);
			}
			if (n2 != null)
				teams.add(teams.size(), n2);
		}		
		return teams;
	}

	@Override
	public List<Integer> levelCommissions(List<Node1> teams) {
		List<Integer> levelCommissions = new ArrayList<Integer>();
		for (int i = 0, k = 0; i < 5 && k < teams.size(); i++) {
			int value = 0;
			int c = (int) Math.floor(Generate.math2Pow(i));
			System.out.println("xxx" + c);
			for (int j = 0; j < c; j++) {
				try {
					value += teams.get(k++).getCommissions();
				} catch (IndexOutOfBoundsException e) {
					System.err.println(e);
					break;
				}
			}
			levelCommissions.add(value);
		}
		return levelCommissions;
	}
	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

	public void setHeader(Long header) {
		this.header = header;
	}

	public Long getHeader() {
		return header;
	}

	public void setCurrentHeader(Long currentHeader) {
		this.currentHeader = currentHeader;
	}

	public Long getCurrentHeader() {
		return currentHeader;
	}

}
