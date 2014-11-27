function OnLoad()
{
	var Focused=false;
	var FocusElementIndex=-1;

	if(document.forms.length > 0)
	{
		if (document.forms[0].elements.length > 0)
		{
			for (i=0;i<document.forms[0].elements.length;i++)
			{
				if(document.forms[0].elements[i].type != "hidden" && Focused==false)
				{
					FocusElementIndex=i;
					Focused=true;
				}
			}
		}
	}

	if (FocusElementIndex >= 0)
	{
		document.forms[0].elements[FocusElementIndex].focus();
	}
}

function chkMandatory(objControl,strMessage,setFocusOnError,pType,strPleaseSelect) 
{
	var lbSetFocus	= new Boolean(true);
 	var strVal		= objControl.value;
	var strType		= objControl.type;
	if (!strPleaseSelect){
		strPleaseSelect = '';
	}

	if (typeof(setFocusOnError) == 'boolean')
		lbSetFocus	= setFocusOnError;
		
	if (strType=='select-multiple' || strType=='select-one')
	{
		if (objControl.options.selectedIndex<=0)
		{
			alert(strMessage);
			if (lbSetFocus)
				objControl.focus();
			return false;
		}
	}
	else if (objControl.type=='radio' || objControl.type=='checkbox')
	{
		if (objControl.checked == false)
		{
			alert(strMessage);
			if (lbSetFocus)
				objControl.focus();
			return false;
		}
	}
	else if (objControl.length > 1 && objControl[0].type=='radio')
	{
		var rvalue = 0;
		for(var i=0; i<objControl.length; i++)
		{
			if (objControl[i].checked == true)
			{
			 	rvalue = 1;
				break
			}
		}
		if (rvalue == 0)
		{
			alert(strMessage);
			if (lbSetFocus)
				objControl[0].focus();
			return false;
		}
	}
	else
	{
		var outStr = "";

		for (var n = 1 ; n <= strVal.length ; n++) 
		{
			if (strVal.substring(n-1,n) == " ") 
			{ 
				outStr+=""; 
			}
			else 
			{ 
				outStr+=strVal.substring(n-1,n); 
			}
		}

		if (outStr == "")
		{
			objControl.value=outStr;
			alert(strMessage);
			if (lbSetFocus && objControl.type!="hidden")
				objControl.focus();
			return false;
		}
		else if (strVal == strPleaseSelect)
		{
			alert(strMessage);
			if (lbSetFocus)
				objControl.focus();
			return false;
		}
	}
	return true;
}

function chkMandatoryNoAlert(objControl,strPleaseSelect)
{
 	var strVal=objControl.value;
	var strType=objControl.type;
	if (!strPleaseSelect){
		strPleaseSelect = '';
	}
	if (strType=='select-multiple' || strType=='select-one')
	{
		if (objControl.options.selectedIndex<=0)
		{
			return false;
		}
	}
	else if (objControl.type=='radio' || objControl.type=='checkbox')
	{
		if (objControl.checked == false)
		{
			return false;
		}
	}
	else if (objControl.length > 1 && objControl[0].type=='radio')
	{
		var rvalue = 0;
		for(var i=0; i<objControl.length; i++)
		{
			if (objControl[i].checked == true)
			{
			 	rvalue = 1;
				break
			}
		}
		if (rvalue == 0)
		{
			return false;
		}
	}
	else
	{
		var outStr = "";
		for (var n=1;n<=strVal.length;n++) 
		{
			if (strVal.substring(n-1,n) == " ") 
			{ 
				outStr+=""; 
			}
			else 
			{ 
				outStr+=strVal.substring(n-1,n); 
			}
		}
		if (outStr == "")
		{
			objControl.value=outStr;
			return false;
		}
		else if (strVal == strPleaseSelect)
		{
			return false;
		}
	}
	return true;
}

function chkLength(objControl,iMinLen,strMessage)
{
	if (objControl.value.length < iMinLen)
	{
		alert(strMessage);
		objControl.focus();
		return false;
	}
	return true;
}

function chkNumeric(objControl,strMessage)
{
	var strNum= new String();
	if(objControl.value != '')
	{
		strNum=objControl.value;
		var numPat=/^\d+(\.\d+)?$/;
		var matchArray=strNum.match(numPat);
		if(matchArray==null)
		{
			if(strMessage != '')
			{
				alert(strMessage);
				objControl.focus();
			}
			return false;
		}
	}
	return true;
}

function chkInteger(objControl,strMessage)
{
	var strNum= new String();
	strNum=objControl.value;
	var numPat= /^\d*$/;
	var matchArray=strNum.match(numPat);
	if(matchArray==null)
	{
		alert(strMessage);
		objControl.focus();
		return false;
	}
	return true;
}


function chkTextAreaLength(objControl,iMinLen,strMessage)
{
	if (objControl.value.length > iMinLen)
	{
		alert(strMessage);
		objControl.focus();
		return false;
	}
	return true;
}
function chkSSN(objControl,strMessage,WithDashes)
{
	if (objControl.value != '')
	{
		var lbWithDashes	= new String('N');
		if (typeof(WithDashes) == 'string')
			lbWithDashes = WithDashes;
		var matchArr 		= objControl.value.match(/^(\d{3})-?\d{2}-?\d{4}$/);
		var numDashes 		= objControl.value.split('-').length - 1;
		if(lbWithDashes == 'Y')
		{
			if (matchArr == null || numDashes != 2)
			{
				if(strMessage != '' )
				{
					alert(strMessage);
					objControl.focus();
				}
				return false;
			}
		}	
		else
		{
			if (matchArr == null || numDashes > 0)
			{
				if(strMessage != '' )
				{
					alert(strMessage);
					objControl.focus();
				}
				return false;
			}
		}
		if (parseInt(matchArr[1],10)==0)
		{
			if(strMessage != '' )
			{
				alert(strMessage);
				objControl.focus();
			}
			return false;
		}
	}
	return true;
}

function getValue(objControl, dataType) 
{
 	var strVal		= '';
	var strType		= '';
	var i = 0;
	
	if(dataType != 4)
	{
		strVal		= objControl.value;
		strType		= objControl.type;
		if (strType=='select-multiple' || strType=='select-one')
		{
			return objControl.value;
		}
		else if ((objControl.type=='radio' || objControl.type=='checkbox') && objControl.length == 1)
		{
			if(objControl.checked)
			{
				return objControl.value;
			}
		}
		else if (objControl.length > 1 && objControl[0].type=='radio')
		{
			for(var i = 0; i < objControl.length; i++)
			{
				if (objControl[i].checked == true)
				{
				 	return objControl[i].value;
				}
			}
		}
		else
		{
			return objControl.value.replace(/^\s*/, "").replace(/\s*$/, "");
		}
	}
	else
	{
		if(objControl.length == 2 && objControl[0].value > 0)
		{
			if(chkDate(objControl,'N','','','MY','N'))
				return new Date(objControl[1].value, objControl[0].value-1, 1);
		}
		else if(objControl.length == 3 && objControl[0].value > 0)
		{
			if(chkDate(objControl,'N','','','MDY','N'))
				return new Date(objControl[2].value, objControl[0].value-1, objControl[1].value);
		}
		else
			return '';
	}
	return '';
}

function compareDate(Left, Right, op)
{
	if(Left != 'CurrentDate')
		var LeftVal = getValue(Left, 4);
	else
	{
		var LeftVal = new Date();
		LeftVal = new Date(LeftVal.getFullYear(), LeftVal.getMonth(), LeftVal.getDate());
	}
	
	if(Right != 'CurrentDate')
		var RightVal = getValue(Right, 4);
	else
	{
		var RightVal = new Date();
		RightVal = new Date(RightVal.getFullYear(), RightVal.getMonth(), RightVal.getDate());
	}
	
	if(LeftVal != '' && RightVal != '')
		return eval('LeftVal  ' + op + ' RightVal');		
	return true;
}
// Please leave these comments as they prevent JavaScript functions from running together in Netscape!
// End of Date Validation Functions

