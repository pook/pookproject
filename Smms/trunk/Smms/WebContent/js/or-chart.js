function orgJSON(data) {
		var x = $(popuphtml());
		var hideDelay = 500;
		var hideTimer = null;
		var backward = 0;
		var dat = data;
		loopteamschild(data);
		fetchlevel(dat.level);
		function cmouseover() {
			if (hideTimer)
				clearTimeout(hideTimer);
			var pos = $(this).offset();
			var width = $(this).width();
			var g = null;
			g = $(this).attr("id");
			var idx = g.substring(1);
			var txt = dat.teams[idx - 1].user;
			var txt1 = dat.teams[idx - 1].displayName;
			var inv = dat.teams[idx - 1].inviter;
			var img = '';
			if (dat.teams[idx - 1].status == 'A') {
				img = $(imgactive());
			} else if (dat.teams[idx - 1].status == 'I') {
				img = $(imginactive());
			} else {
				img = $(imginactive());
			}
			if (txt == null || txt == 'undefine' || txt.length < 3) {
				return;
			} else {
				$("#name1").empty().append("" + txt1);
				$("#nid1").empty().append("" + txt);
				$("#status").empty().append(img);
				$("#inv").empty().append("" + inv);
			}
			$("body").append(x);
			switch (g) {
			case "n1":
				x.css({
					"height" : "30px",
					left : (pos.left + (width - 430)) + 'px',
					top : (pos.top - 52) + 'px'
				});
				break;
			case "n2":
			case "n3":
				x.css({
					"height" : "50px",
					left : (pos.left + (width - 200)) + 'px',
					top : (pos.top - 52) + 'px'
				});
				break;
			case "n4":
			case "n5":
			case "n6":
				x.css({
					"height" : "50px",
					left : (pos.left + width) + 'px',
					top : (pos.top - 52) + 'px'
				});
				break;
			case "n7":
				x.css({
					"height" : "50px",
					left : (pos.left + (width - 500)) + 'px',
					top : (pos.top - 52) + 'px'
				});
				break;
			case "n15":
			case "n14":
				x.css({
					"height" : "50px",
					left : (pos.left + (width - 400)) + 'px',
					top : (pos.top - 52) + 'px'
				});
				break;
			case "n30":
			case "n31":
				x.css({
					"height" : "50px",
					left : (pos.left + (width - 180)) + 'px',
					top : (pos.top - 120) + 'px'
				});
				break;
			case "n63":
			case "n62":
			case "n61":
			case "n60":
				x.css({
					"height" : "50px",
					left : (pos.left + (width - 180)) + 'px',
					top : (pos.top - 80) + 'px'
				});
				break;
			default:
				x.css({
					"height" : "50px",
					left : (pos.left + (width + 19)) + 'px',
					top : (pos.top - 52) + 'px'
				});
			}
			x.css('display', 'block');
		}
		function cmouseclick(data) {
			clrErrInf();
			var g = $(this).attr("id");
			var idx = parseInt(g.substring(1));
			if (idx > dat.teams.length)
				return;
			var nid = dat.teams[idx - 1].nodeId;
			$.ajax({
				type : "get",
				url : jsondat,
				data : "nodeId=" + nid + "&backward=" + backward,
				success : function(data1) {
					dat = data1;					
					loopteamschild(dat);					
					fetchlevel(dat.level);
				}
			});
		}
		var ck_search = /[A-Za-z]{2}[0-9]{10}$/;
		function searchclick() {
			clrErrInf();
			var s = $("#searchuser");
			var m = s.val();
			if (!ck_search.test(m)) {
				showmsgErr("รหัสสมาชิก ผิดพลาด");
				$("#searchuser").empty().val("");
				return;
			}
			$.ajax({
				type : "get",
				url : jsonsearch,
				data : "memberid=" + m,
				success : function(data1) {
					if (data1.messageError) {
						showmsgInf(data1.messageError[0]);
						$("#searchuser").empty().val("");
						return;
					}
					dat = data1;
					loopteamschild(dat);
					fetchlevel(dat.level);
					$("#searchuser").empty().val("");
				}
			});
		}
		function showmsgInf(msgInf) {
			$("#messageInfo")
					.addClass("ui-state-highlight ui-corner-all")
					.empty()
					.append(
							"<p><span style='float: left; margin-right: 0.3em;' class='ui-icon ui-icon-info'></span>"
									+ "</strong> " + msgInf + "</p>");

		}
		function showmsgErr(msgErr) {
			$("#messageError")
					.addClass("ui-state-error  ui-corner-all")
					.empty()
					.append(
							"<p><span id='iconAlert' style='float: left; margin-right: 0.3em;' class='ui-icon ui-icon-alert'></span>"
									+ "<strong>Alert:</strong> "
									+ msgErr
									+ "</p>");

		}
		function addbackwardhover() {
			$(this).addClass("ui-state-hover ui-corner-all");
		}
		function removebackwardhover() {
			$(this).removeClass("ui-state-hover ui-corner-all");
		}
		function clrErrInf() {
			$("#messageInfo").removeClass("ui-state-highlight ui-corner-all")
					.empty();
			$("#messageError").removeClass("ui-state-error ui-corner-all")
					.empty();
		}
		$("#abackword").live("mouseover", addbackwardhover);
		$("#abackword1").live("mouseover", addbackwardhover);
		$("#abackword6").live("mouseover", addbackwardhover);
		$("#fsubmit").live("mouseover", addbackwardhover);
		$("#n1").live("mouseover", cmouseover);
		$("#n2").live("mouseover", cmouseover);
		$("#n3").live("mouseover", cmouseover);
		$("#n4").live("mouseover", cmouseover);
		$("#n5").live("mouseover", cmouseover);
		$("#n6").live("mouseover", cmouseover);
		$("#n7").live("mouseover", cmouseover);
		$("#n8").live("mouseover", cmouseover);
		$("#n9").live("mouseover", cmouseover);
		$("#n10").live("mouseover", cmouseover);
		$("#n11").live("mouseover", cmouseover);
		$("#n12").live("mouseover", cmouseover);
		$("#n13").live("mouseover", cmouseover);
		$("#n14").live("mouseover", cmouseover);
		$("#n15").live("mouseover", cmouseover);
		$("#n16").live("mouseover", cmouseover);
		$("#n17").live("mouseover", cmouseover);
		$("#n18").live("mouseover", cmouseover);
		$("#n19").live("mouseover", cmouseover);
		$("#n20").live("mouseover", cmouseover);
		$("#n21").live("mouseover", cmouseover);
		$("#n22").live("mouseover", cmouseover);
		$("#n23").live("mouseover", cmouseover);
		$("#n24").live("mouseover", cmouseover);
		$("#n25").live("mouseover", cmouseover);
		$("#n26").live("mouseover", cmouseover);
		$("#n27").live("mouseover", cmouseover);
		$("#n28").live("mouseover", cmouseover);
		$("#n29").live("mouseover", cmouseover);
		$("#n30").live("mouseover", cmouseover);
		$("#n31").live("mouseover", cmouseover);
		$("#n32").live("mouseover", cmouseover);
		$("#n33").live("mouseover", cmouseover);
		$("#n34").live("mouseover", cmouseover);
		$("#n35").live("mouseover", cmouseover);
		$("#n36").live("mouseover", cmouseover);
		$("#n37").live("mouseover", cmouseover);
		$("#n38").live("mouseover", cmouseover);
		$("#n39").live("mouseover", cmouseover);
		$("#n40").live("mouseover", cmouseover);
		$("#n41").live("mouseover", cmouseover);
		$("#n42").live("mouseover", cmouseover);
		$("#n43").live("mouseover", cmouseover);
		$("#n44").live("mouseover", cmouseover);
		$("#n45").live("mouseover", cmouseover);
		$("#n46").live("mouseover", cmouseover);
		$("#n47").live("mouseover", cmouseover);
		$("#n48").live("mouseover", cmouseover);
		$("#n49").live("mouseover", cmouseover);
		$("#n50").live("mouseover", cmouseover);
		$("#n51").live("mouseover", cmouseover);
		$("#n52").live("mouseover", cmouseover);
		$("#n53").live("mouseover", cmouseover);
		$("#n54").live("mouseover", cmouseover);
		$("#n55").live("mouseover", cmouseover);
		$("#n56").live("mouseover", cmouseover);
		$("#n57").live("mouseover", cmouseover);
		$("#n58").live("mouseover", cmouseover);
		$("#n59").live("mouseover", cmouseover);
		$("#n60").live("mouseover", cmouseover);
		$("#n61").live("mouseover", cmouseover);
		$("#n62").live("mouseover", cmouseover);
		$("#n63").live("mouseover", cmouseover);

		$("#abackword").live("mouseout", removebackwardhover);
		$("#abackword1").live("mouseout", removebackwardhover);
		$("#abackword6").live("mouseout", removebackwardhover);
		$("#fsubmit").live("mouseout", removebackwardhover);
		$("#n1").live("mouseout", cmouseout);
		$("#n2").live("mouseout", cmouseout);
		$("#n3").live("mouseout", cmouseout);
		$("#n4").live("mouseout", cmouseout);
		$("#n5").live("mouseout", cmouseout);
		$("#n6").live("mouseout", cmouseout);
		$("#n7").live("mouseout", cmouseout);
		$("#n8").live("mouseout", cmouseout);
		$("#n9").live("mouseout", cmouseout);
		$("#n10").live("mouseout", cmouseout);
		$("#n11").live("mouseout", cmouseout);
		$("#n12").live("mouseout", cmouseout);
		$("#n13").live("mouseout", cmouseout);
		$("#n14").live("mouseout", cmouseout);
		$("#n15").live("mouseout", cmouseout);
		$("#n16").live("mouseout", cmouseout);
		$("#n17").live("mouseout", cmouseout);
		$("#n18").live("mouseout", cmouseout);
		$("#n19").live("mouseout", cmouseout);
		$("#n20").live("mouseout", cmouseout);
		$("#n21").live("mouseout", cmouseout);
		$("#n22").live("mouseout", cmouseout);
		$("#n23").live("mouseout", cmouseout);
		$("#n24").live("mouseout", cmouseout);
		$("#n25").live("mouseout", cmouseout);
		$("#n26").live("mouseout", cmouseout);
		$("#n27").live("mouseout", cmouseout);
		$("#n28").live("mouseout", cmouseout);
		$("#n29").live("mouseout", cmouseout);
		$("#n30").live("mouseout", cmouseout);
		$("#n31").live("mouseout", cmouseout);
		$("#n32").live("mouseout", cmouseout);
		$("#n33").live("mouseout", cmouseout);
		$("#n34").live("mouseout", cmouseout);
		$("#n35").live("mouseout", cmouseout);
		$("#n36").live("mouseout", cmouseout);
		$("#n37").live("mouseout", cmouseout);
		$("#n38").live("mouseout", cmouseout);
		$("#n39").live("mouseout", cmouseout);
		$("#n40").live("mouseout", cmouseout);
		$("#n41").live("mouseout", cmouseout);
		$("#n42").live("mouseout", cmouseout);
		$("#n43").live("mouseout", cmouseout);
		$("#n44").live("mouseout", cmouseout);
		$("#n45").live("mouseout", cmouseout);
		$("#n46").live("mouseout", cmouseout);
		$("#n47").live("mouseout", cmouseout);
		$("#n48").live("mouseout", cmouseout);
		$("#n49").live("mouseout", cmouseout);
		$("#n50").live("mouseout", cmouseout);
		$("#n51").live("mouseout", cmouseout);
		$("#n52").live("mouseout", cmouseout);
		$("#n53").live("mouseout", cmouseout);
		$("#n54").live("mouseout", cmouseout);
		$("#n55").live("mouseout", cmouseout);
		$("#n56").live("mouseout", cmouseout);
		$("#n57").live("mouseout", cmouseout);
		$("#n58").live("mouseout", cmouseout);
		$("#n59").live("mouseout", cmouseout);
		$("#n60").live("mouseout", cmouseout);
		$("#n61").live("mouseout", cmouseout);
		$("#n62").live("mouseout", cmouseout);
		$("#n63").live("mouseout", cmouseout);

		$("#n1").live("click", cmouseclick);
		$("#n2").live("click", cmouseclick);
		$("#n3").live("click", cmouseclick);
		$("#n4").live("click", cmouseclick);
		$("#n5").live("click", cmouseclick);
		$("#n6").live("click", cmouseclick);
		$("#n7").live("click", cmouseclick);
		$("#n8").live("click", cmouseclick);
		$("#n9").live("click", cmouseclick);
		$("#n10").live("click", cmouseclick);
		$("#n11").live("click", cmouseclick);
		$("#n12").live("click", cmouseclick);
		$("#n13").live("click", cmouseclick);
		$("#n14").live("click", cmouseclick);
		$("#n15").live("click", cmouseclick);
		$("#n16").live("click", cmouseclick);
		$("#n17").live("click", cmouseclick);
		$("#n18").live("click", cmouseclick);
		$("#n19").live("click", cmouseclick);
		$("#n20").live("click", cmouseclick);
		$("#n21").live("click", cmouseclick);
		$("#n22").live("click", cmouseclick);
		$("#n23").live("click", cmouseclick);
		$("#n24").live("click", cmouseclick);
		$("#n25").live("click", cmouseclick);
		$("#n26").live("click", cmouseclick);
		$("#n27").live("click", cmouseclick);
		$("#n28").live("click", cmouseclick);
		$("#n29").live("click", cmouseclick);
		$("#n30").live("click", cmouseclick);
		$("#n31").live("click", cmouseclick);
		$("#n32").live("click", cmouseclick);
		$("#n33").live("click", cmouseclick);
		$("#n34").live("click", cmouseclick);
		$("#n35").live("click", cmouseclick);
		$("#n36").live("click", cmouseclick);
		$("#n37").live("click", cmouseclick);
		$("#n38").live("click", cmouseclick);
		$("#n39").live("click", cmouseclick);
		$("#n40").live("click", cmouseclick);
		$("#n41").live("click", cmouseclick);
		$("#n42").live("click", cmouseclick);
		$("#n43").live("click", cmouseclick);
		$("#n44").live("click", cmouseclick);
		$("#n45").live("click", cmouseclick);
		$("#n46").live("click", cmouseclick);
		$("#n47").live("click", cmouseclick);
		$("#n48").live("click", cmouseclick);
		$("#n49").live("click", cmouseclick);
		$("#n50").live("click", cmouseclick);
		$("#n51").live("click", cmouseclick);
		$("#n52").live("click", cmouseclick);
		$("#n53").live("click", cmouseclick);
		$("#n54").live("click", cmouseclick);
		$("#n55").live("click", cmouseclick);
		$("#n56").live("click", cmouseclick);
		$("#n57").live("click", cmouseclick);
		$("#n58").live("click", cmouseclick);
		$("#n59").live("click", cmouseclick);
		$("#n60").live("click", cmouseclick);
		$("#n61").live("click", cmouseclick);
		$("#n62").live("click", cmouseclick);
		$("#n63").live("click", cmouseclick);
		$("#fsubmit").live("click", searchclick);
		$("#abackword").live("click", rootmouseclick);
		$("#abackword1").live("click", backmouseclick1);
		$("#abackword6").live("click", backmouseclick6);
		function rootmouseclick(data) {
			clrErrInf();
			$.ajax({
				type : "get",
				url : jsondat,
				data : "nodeId=-2",
				success : function(data1) {
					dat = data1;
					loopteamschild(dat);
					fetchlevel(dat.level);
				}
			});
		}
		function backmouseclick(back) {
			clrErrInf();
			$.ajax({
				type : "get",
				url : jsonbw,
				data : "nodeId=" + dat.teams[0].nodeId + "&back=" + back,
				success : function(data1) {
					dat = data1;
					loopteamschild(dat);
					fetchlevel(dat.level);
				}
			});
		}
		function backmouseclick1() {
			backmouseclick(1);
		}
		function backmouseclick6() {
			backmouseclick(6);
		}
		function cmouseout(data) {
			if (hideTimer)
				clearTimeout(hideTimer);
			hideTimer = setTimeout(function() {
				x.css('display', 'none');
			}, hideDelay);
		}
	}
	function loopteamschild(data) {
		clearteams();		
		$.each(data.teams, function(idx, value) {
			var po1 = -1;
			switch (idx) {
			case 0:
				po1 = 418;
				break;
			case 1:case 2:
				po1 = 178;
				break;
			case 3:case 4:case 5:case 6:
				po1 = 59;
				break;
			case 7:case 8:case 9:case 10:case 11:case 12:case 13:case 14:
				po1 = 7;
				break;				
			default:
				po1 = -6;
			}					
			var t1 = value.user;
			var im = '';			
			if (value.status == 'A') {
				im = imgactive();
			} else if (value.status == 'I') {
				im = imginactive();
			} else {
				im = imginactive();
			}
			if (t1 == null || t1 == 'undefine' || t1.length < 3) {
				return;
			}						
			if(idx<15){
				var t2 = value.displayName,inv2 = value.inviter;
				$("#n" + (idx + 1)).empty().html(
					boxhtml(im, t2,t1, inv2, po1));
			}else{
				$("#n" + (idx + 1)).empty().html(
						boxhtml2(im, po1));
			}				
		});		
	}
	function boxhtml(img, a1, a2, a3, po1) {
		return "<font size='-2'><table style='margin-left:"+po1 +"px'><tr >"
				+ "<td rowspan='3'>" + img + "</td><td>" + a1 + "</td>"
				+ "<tr><td>" + a2 + "</td><tr>" + "<td>" + a3 + "</td>"
				+ "</tr></table></font>";
	}
	function boxhtml2(img, po1) {
		return "<font size='-2'><table style='margin-left:"+po1 +"px'><tr >"
				+ "<td>" + img + "</td>"
				+ "</tr></table></font>";
	}
	
	function fetchlevel(data1) {
		$.each(data1,
				function(idx, value) {
					$("#lv" + (idx + 1)).empty().append(
							"<font size='-1'>" + value
									+ "</font><strong> SV</strong>");
				});
	}
	function clearteams() {
		for ( var i = 0; i < 63; i++) {
			$("#n" + (i + 1)).empty().append("&nbsp;");
		}				
	}
	function popuphtml() {
		return "<div id='personPopupContainer'>"
				+ "<table id ='tablepopup' width='300' border='0'  cellspacing='0' cellpadding='0' align='center' class='personPopupPopup'>"
				+ "<tr>" + "<td class='corner topLeft'></td>"
				+ "<td class='top'></td>" + "<td class='corner topRight'></td>"
				+ "</tr><tr><td class='left'></td><td>"
				+ "<table style='background-color:#fff'><tr >"
				+ "<td id='status' rowspan='3'></td>" + "<td id='name1'></td>"
				+ "<tr><td id='nid1'></td><tr>" + "<td id='inv'></td>"
				+ "</tr></table></td> <td class='right'></td>"
				+ "</tr><tr><td class='corner bottomLeft'></td>"
				+ "<td class='bottom'></td>"
				+ " <td class='corner bottomRight'></td></tr></table>"
				+ "</div>";
	}
	function imgactive() {
		return "<img  src='images/Active.png' style='height:24px;width:24px;border:none'/>";
	}
	function imginactive() {
		return "<img  src='images/Inactive.png' style='height:24px;width:24px;border:none'/>";
	}