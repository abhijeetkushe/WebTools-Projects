// Validate VE Data Control created date.  Validate Day/Month/Year combo box type.
function isDateCombo(DateString,seperator,type)
{
	var reDate1=/^([0-9]+)\.+([0-9]+)\.+([0-9]+)$/;
	var reDate2=/^([0-9]+)\-+([0-9]+)\-+([0-9]+)$/;
	var reDate3=/^([0-9]+)\/+([0-9]+)\/+([0-9]+)$/;

	if(seperator==".")
  	{
  		reDate=reDate1;
	}
	else if (seperator=="-")
	{
  		reDate=reDate2;
	}
	else if (seperator=="/")
	{
  		reDate=reDate3;
	}

  	var sun = DateString;
	var i;
 	var a = new Array();
 	var b,c;
 	var x=0;

 	if (reDate.test(DateString))							
 	{ 
		newstr = sun.split(reDate,"$1,$2,$3");       // in the format specified
		if(type=="MDY")
		{
			var mm_from1 = RegExp.$1;
          	var dd_from1 = RegExp.$2;
           	var yy_from1 = RegExp.$3;
	   	}
	   	else if (type=="DMY")
	   	{
	   		var mm_from1 = RegExp.$2;
        	var dd_from1 = RegExp.$1;
          	var yy_from1 = RegExp.$3;
	   	}
   	}
   	else
    { 
		return false; 
	}

  	if(yy_from1  < 1900 )
    {
		return false; 
	}

  	if(!reDate.test(DateString))
    {
		return false; 
	}
  	else
	{
   		for(i=0;i<DateString.length;i++)
    	{ 
	  		if (DateString.charAt(i) == " ")
	  		{ 
	   			return false; 
		  	}
	  		else
     		{	
	 			a[i] = DateString.charAt(i); 
				if (a[i] == seperator) {x++;} 
	 		}
   		}
   
	   	if (x > 2)	
		{ 
			return false; 
		}	
	   	else if (((a[1] == seperator)  || (a[2] == seperator)) && ((a[3] == seperator)  || (a[4] == seperator) || (a[5] == seperator)))
	   	{
	   		if ((a[1] == seperator) && (a[3] == seperator))
	    	{
		   		if ((a[6] != null) && (a[7] != null))
	      		{
		  			DateString=("0"+a[0]+a[1]+"0"+a[2]+a[3]+a[4]+a[5]+a[6]+a[7]);
		  		}
		  		else if (a[5] == null) 
		  		{ 
		    		return false; 
		  		} 
		  		else if ((((a[6] == null) && (a[7] == null)) || ((a[6] == "") && (a[7] == ""))) && (a[4] < 4))
		  		{
		  			DateString=("0"+a[0]+a[1]+"0"+a[2]+a[3]+"20"+a[4]+a[5]);
		  		}
		  		else if ((((a[6] == null) && (a[7] == null)) || ((a[6] == "") && (a[7] == ""))) && (a[4] >= 4))
		   		{
		   			DateString=("0"+a[0]+a[1]+"0"+a[2]+a[3]+"19"+a[4]+a[5]);
		   		}
		   		else
		   		{
		   			return false; 
		   		}
	   		}
	  		else if ((a[2] == seperator) && (a[4] == seperator))
	    	{
		   		if ((a[7] != null) && (a[8] != null))
	      		{
		  			DateString=(a[0]+a[1]+a[2]+"0"+a[3]+a[4]+a[5]+a[6]+a[7]+a[8]);
		  		}
		  		else if (a[6] == null) 
		  		{ 
		   			return false; 
		  		} 	   
		  		else if ((((a[7] == null) && (a[8] == null)) || ((a[7] == "") && (a[8] == ""))) && (a[5] < 4))
		  		{
		  			DateString=(a[0]+a[1]+a[2]+"0"+a[3]+a[4]+"20"+a[5]+a[6]);
		  		}
		  		else if ((((a[7] == null) && (a[8] == null)) || ((a[7] == "") && (a[8] == ""))) && (a[5] >= 4))
	      		{
		  			DateString=(a[0]+a[1]+a[2]+"0"+a[3]+a[4]+"19"+a[5]+a[6]);
		  		}
		  		else
		  		{
		    		return false; 
		  		}
		 	} 
	 	 	else if ((a[2] == seperator) && (a[5] == seperator))
	   		{
		   		if ((a[8] != null) && (a[9] != null))
	       		{
		  	 		DateString=(a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7]+a[8]+a[9]);
		   		}
		   		else if (a[7] == null) 
		   		{
		     		return false; 
		   		}
		   		else if ((((a[8] == null) && (a[9] == null)) || ((a[8] == "") && (a[9] == ""))) && (a[6] < 4))
		   		{
		 			DateString=(a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+"20"+a[6]+a[7]);
	       		}
		   		else if ((((a[8] == null) && (a[9] == null)) || ((a[8] == "") && (a[9] == ""))) && (a[6] >= 4))
		   		{
		   			DateString=(a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+"19"+a[6]+a[7]);
		   		}
		   		else
		   		{
		   			return false; 
		   		}
	   		} 
		 	else if ((a[1] == seperator) && (a[4] == seperator))
	   		{
		   		if ((a[7] != null) && (a[8] != null))
	      		{
					DateString=("0"+a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7]+a[8]);
				}
		   		else if (a[6] == null)
				{	
		    		return false;
				} 	   
		   		else if ((((a[7] == null) && (a[8] == null)) || ((a[7] == null) && (a[8] == null))) && (a[5] < 4))
		   		{
					DateString=("0"+a[0]+a[1]+a[2]+a[3]+a[4]+"20"+a[5]+a[6]);
				}
		   		else if ((((a[7] == null) && (a[8] == null)) || ((a[7] == null) && (a[8] == null))) && (a[5] >= 4))
			   	{
			   		DateString=("0"+a[0]+a[1]+a[2]+a[3]+a[4]+"19"+a[5]+a[6]);
				}
		   		else
		   		{
			   		return false;
				}
		   	} 
		  	else 
	      	{ 
	   			return false; 
		  	} 	

			// Convert to integers for numeric comparisons (MAC version of Netscape treat these values
			// as strings and the comparison fail.)
	 		var mm = parseInt(mm_from1);
	 		var dd = parseInt(dd_from1);
	 		var yy = parseInt(yy_from1);
	  
	 		if ((dd == "") || (dd == 0) || (dd > 31))
	  		{ 
	  			return false; 
	  		}
	 		else if((mm == "") || (mm == 0) || (mm > 12))
	  		{ 
	  			return false; 
	  		}
	 		else if (((yy % 100) == 0) && (mm == 2) && (dd == 29))			// Leap Year Check
	        { 
				if (((yy %400) == 0) && (mm == 2) && (dd == 29))
			        return true; 
		        else
				{
					return false;
				}
			}
		  	else if (((yy % 4) == 0) && (mm == 2) && (dd == 29))
			   return true;  
	 		else if (((mm == 4) || (mm == 6) || (mm == 9) || (mm == 11)) && (dd > 30)) 
	  		{
	   			return false; 
	  		}
	 		else if ((mm == 2) && (dd > 28)) 
	  		{
	  			return false; 
	  		}   
	 		else if ((mm == 2) && (dd > 29) && (((yy % 4) != 0) || ((yy % 100) != 0) || ((yy %400) != 0)))
	  		{
	   			return false; 
	  		}
	 		else if (yy < 1900)
	  		{
	   			return false; 
	  		}
	 	}
	 	else
	 	{
	 		return false; 
		}
	}
	return true;
}

// Please leave these comments as they prevent JavaScript functions from running together in Netscape!
// End of Date Validation Functions
function chkDate(CtrlName,Required,ReqdMsg,InvalidDateMsg,DateMask,Alert)
{
	var lbAlert	= new String('Y');
	if (typeof(Alert) == 'string')
		lbAlert	= Alert;
	if(DateMask == '')
	{
		alert('Invalid DateMask');
		return false;
	}
	if(Required == 'Y' || Required == 'y')
	{
		if(DateMask == 'MDY')
		{
			if (parseInt(CtrlName[0].value) == 0 && parseInt(CtrlName[1].value) == 0 && parseInt(CtrlName[2].value) == 0)
			{
				if(lbAlert == 'Y')
				{
	        	     alert(ReqdMsg);
					 CtrlName[0].focus();
				}	 
				return false;
    	    }
		}
		else if(DateMask == 'MY')
		{
			if (parseInt(CtrlName[0].value) == 0 && parseInt(CtrlName[1].value) == 0)
			{
				if(lbAlert == 'Y')
				{
	        	     alert(ReqdMsg);
					 CtrlName[0].focus();
				}	 
				return false;
    	    }
		}
	}
	if(DateMask == 'MDY')
	{
		if (parseInt(CtrlName[0].value) != 0 || parseInt(CtrlName[1].value) != 0 || parseInt(CtrlName[2].value) != 0)
		{
			if(isDateCombo(CtrlName[0].value + '/' + CtrlName[1].value + '/' + CtrlName[2].value,"/","MDY")==false)
			{
				if(lbAlert == 'Y')
				{
					alert(InvalidDateMsg);
					CtrlName[0].focus();
				}	
				return false;
			}	
	     }
	}	 
	else if(DateMask == 'MY')
	{
		if ((parseInt(CtrlName[0].value) == 0 && parseInt(CtrlName[1].value) != 0) || (parseInt(CtrlName[0].value) != 0 && parseInt(CtrlName[1].value) == 0))
		{
			if(lbAlert == 'Y')
			{
				alert(InvalidDateMsg);
				CtrlName[0].focus();
			}	
			return false;
	     }
	}
	 return true;
}

function chkDateStartEnd(SCtrlName,ECtrlName,EMsg,DateMask,Alert,DateDiff,EMsgDateDiff)
{
	var lbAlert	= new String('Y');
	if (typeof(Alert) == 'string' && Alert != '')
		lbAlert	= Alert;
	var lnMaxDateDiff	= new Number(0);
	if (typeof(DateDiff) == 'string' && DateDiff != '')
		lnMaxDateDiff	= DateDiff;
	if(DateMask == 'MDY')
	{
		if (parseInt(SCtrlName[0].value) != 0 && parseInt(SCtrlName[1].value) != 0 && parseInt(SCtrlName[2].value) != 0)
				if(parseInt(ECtrlName[0].value) == 0 && parseInt(ECtrlName[1].value) == 0 && parseInt(ECtrlName[2].value) == 0)
					{
						if(lbAlert == 'Y')
						{
							alert(EMsg);
							ECtrlName[0].focus();
						}	
						return false;
					}
		if (parseInt(ECtrlName[0].value) != 0 && parseInt(ECtrlName[1].value) != 0 && parseInt(ECtrlName[2].value) != 0)
				if(parseInt(SCtrlName[0].value) == 0 && parseInt(SCtrlName[1].value) == 0 && parseInt(SCtrlName[2].value) == 0)
					{
						if(lbAlert == 'Y')
						{
							alert(EMsg);
							SCtrlName[0].focus();
						}	
						return false;
					}			
		if (parseInt(SCtrlName[0].value) != 0 && parseInt(SCtrlName[1].value) != 0 && parseInt(SCtrlName[2].value) != 0 && parseInt(ECtrlName[0].value) != 0 && parseInt(ECtrlName[1].value) != 0 && parseInt(ECtrlName[2].value) != 0)
		{
			var ldStartDate = new Date(SCtrlName[2].value,SCtrlName[0].value-1,SCtrlName[1].value);
			var ldEndDate	= new Date(ECtrlName[2].value,ECtrlName[0].value-1,ECtrlName[1].value);
			var lndiff 		= Math.round((ldEndDate - ldStartDate)/(1000*60*60*24));
			if (lndiff < 0)
			{
				if(lbAlert == 'Y')
				{
					alert(EMsg);
					ECtrlName[0].focus();
				}	
				return false;
			}
			if (lnMaxDateDiff > 0 && lndiff > lnMaxDateDiff)
			{			
				if(lbAlert == 'Y')
				{
					alert(EMsgDateDiff);
					ECtrlName[0].focus();
				}	
				return false;
			}
		}
	}	 
	else if(DateMask == 'MY')
	{
		if (parseInt(SCtrlName[0].value) != 0 && parseInt(SCtrlName[1].value) != 0)
				if(parseInt(ECtrlName[0].value) == 0 && parseInt(ECtrlName[1].value) == 0)
					{
						if(lbAlert == 'Y')
						{
							alert(EMsg);
							ECtrlName[0].focus();
						}	
						return false;
					}
		if (parseInt(ECtrlName[0].value) != 0 && parseInt(ECtrlName[1].value) != 0)
				if(parseInt(SCtrlName[0].value) == 0 && parseInt(SCtrlName[1].value) == 0)
					{
						if(lbAlert == 'Y')
						{
							alert(EMsg);
							SCtrlName[0].focus();
						}	
						return false;
					}			
		if (parseInt(SCtrlName[0].value) != 0 && parseInt(SCtrlName[1].value) != 0 && parseInt(ECtrlName[0].value) != 0 && parseInt(ECtrlName[1].value) != 0)
		{
			var ldStartDate = new Date(SCtrlName[1].value,SCtrlName[0].value-1,1);
			var ldEndDate	= new Date(ECtrlName[1].value,ECtrlName[0].value-1,1);
			var lndiff 		= Math.round((ldEndDate - ldStartDate)/(1000*60*60*24));
			if (lndiff < 0)
			{
				if(lbAlert == 'Y')
				{
					alert(EMsg);
					ECtrlName[0].focus();
				}	
				return false;
			}
			if (lnMaxDateDiff > 0 && lndiff > lnMaxDateDiff)
			{			
				if(lbAlert == 'Y')
				{
					alert(EMsgDateDiff);
					ECtrlName[0].focus();
				}	
				return false;
			}
		}
	}	
	return true;
}
/* function to check both start and end date has values */
function chkValidDateStartEnd(SCtrlName,ECtrlName,DateMask)
{
	if(DateMask == 'MDY')
	{
		if (parseInt(SCtrlName[0].value) != 0 && parseInt(SCtrlName[1].value) != 0 && parseInt(SCtrlName[2].value) != 0)
			if(parseInt(ECtrlName[0].value) == 0 && parseInt(ECtrlName[1].value) == 0 && parseInt(ECtrlName[2].value) == 0)
				return false;
		if (parseInt(ECtrlName[0].value) != 0 && parseInt(ECtrlName[1].value) != 0 && parseInt(ECtrlName[2].value) != 0)
			if(parseInt(SCtrlName[0].value) == 0 && parseInt(SCtrlName[1].value) == 0 && parseInt(SCtrlName[2].value) == 0)
				return false;
	}	 
	else if(DateMask == 'MY')
	{
		if (parseInt(SCtrlName[0].value) != 0 && parseInt(SCtrlName[1].value) != 0)
			if(parseInt(ECtrlName[0].value) == 0 && parseInt(ECtrlName[1].value) == 0)
				return false;
		if (parseInt(ECtrlName[0].value) != 0 && parseInt(ECtrlName[1].value) != 0)
			if(parseInt(SCtrlName[0].value) == 0 && parseInt(SCtrlName[1].value) == 0)
				return false;
	}	
	return true;
}