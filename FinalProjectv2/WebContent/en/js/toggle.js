/**
 * @author Abhijeet
 */

function toggleMenu(selId,menuid,imgup,imgdown)
{
	var toggleSelImg=document.getElementById(selId);
	var src=toggleSelImg.src;
	if(src.indexOf("Down")!=-1)
	{
		sign='+';
	}
	else if(src.indexOf("Up")!=-1)
	{
		sign='-';
	}
	if(sign=='+')
	{
		toggleSelImg.src=imgup;
	    var toggleDiv=document.getElementById(menuid);
		toggleDiv.style.display='inline';				
	}
	else if(sign=='-')
	{
		toggleSelImg.src=imgdown;
		var toggleDiv=document.getElementById(menuid);
		toggleDiv.style.display='none';
	}	
}



function submitForm(form,button)
{
  	var uname=form.PROXY_SG_USERNAME.value;
  	var pwd=form.PROXY_SG_PASSWORD.value;
  	var buttonSrc=button.name;
  	if(buttonSrc=="submitImage")
  	{	
  		if ( (uname == "") || (pwd== "") )
  		{
  			alert ("One or more fields are empty. Please fill in all the fields.");
  			var imglink=document.getElementById("submitImage");
  			imglink.href="loginPage.htm";
  			form.PROXY_SG_USERNAME.value=uname;
  			form.PROXY_SG_PASSWORD.value=pwd;
  			return false;
  		}
  		else if(uname=="ASK" && pwd=="9-10-1984")
  		{
        //window.opener=self; 
		//window.close();
		//window.open('profileMain.html','mywindow');
		 //window.open("GET","profileMain.html","false","","");
  			
  			return true;
  		}
  		else 
  		{
  			alert ("Invalid UserName and Password.Login as Guest to view Abhijeet's Profile.");
  			var imglink=document.getElementById("submitImage");
  			imglink.href="loginPage.htm";
  			form.PROXY_SG_USERNAME.value=uname;
  			form.PROXY_SG_PASSWORD.value=pwd;
  			return false;
  		}
  	}
  	else if(buttonSrc=="loginAsImage")
  	{
  		return true;
  	}
   
   
}

function setFocus()
{
	document.forms[0].elements[0].focus();
}


			

