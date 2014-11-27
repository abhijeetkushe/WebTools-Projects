function chkEmail (emailStr,strErrorMsg) {

var checkTLD=1;
var emailStr = emailStr.toUpperCase( );
/* These domains we allow to submit in our database.*/
var knownDomsPat=/^(COM|NET|ORG|EDU|GOV|BIZ|NAME|INFO|MUSEUM|COOP|AERO|PRO|MIL|FR|US|CA|TV|RU|JOBS)$/;
var emailPat=/^(.+)@(.+)$/;
var specialChars="\\(\\)><@,;:\\\\\\\"\\.\\[\\]";
var validChars="\[^\\s" + specialChars + "\]";
var quotedUser="(\"[^\"]*\")";
var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/;
var atom=validChars + '+';
var word="(" + atom + "|" + quotedUser + ")";
var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
var domainPat=new RegExp("^" + atom + "(\\." + atom +")*$");
var matchArray=emailStr.match(emailPat);


if (matchArray==null) {

/* Too many/few @'s or something; basically, this address doesn't
     even fit the general mould of a valid e-mail address. */
if(strErrorMsg != '')
alert(strErrorMsg)
return false;
}
var user=matchArray[1];
var domain=matchArray[2];

// Start by checking that only basic ASCII characters are in the strings (0-127).

for (i=0; i<user.length; i++) {
if (user.charCodeAt(i)>127) {
if(strErrorMsg != '')
alert(strErrorMsg)
return false;
   }
}
for (i=0; i<domain.length; i++) {
if (domain.charCodeAt(i)>127) {
if(strErrorMsg != '')
alert(strErrorMsg)
return false;
   }
}

// See if "user" is valid 

if (user.match(userPat)==null) {

// user is not valid
if(strErrorMsg != '')
alert(strErrorMsg)
return false;
}

/* if the e-mail address is at an IP address (as opposed to a symbolic
host name) make sure the IP address is valid. */

var IPArray=domain.match(ipDomainPat);
if (IPArray!=null) {

// this is an IP address

for (var i=1;i<=4;i++) {
if (IPArray[i]>255) {
if(strErrorMsg != '')
alert(strErrorMsg)
return false;
   }
}
return true;
}

// Domain is symbolic name.  Check if it's valid.
 
var atomPat=new RegExp("^" + atom + "$");
var domArr=domain.split(".");
var len=domArr.length;
for (i=0;i<len;i++) {
if (domArr[i].search(atomPat)==-1) {
if(strErrorMsg != '')
alert(strErrorMsg)
return false;
   }
}

if (checkTLD && domArr[domArr.length-1].length!=2 && domArr[domArr.length-1].search(knownDomsPat)==-1) {
if(strErrorMsg != '')
alert(strErrorMsg)
return false;
}

if (len<2) {
if(strErrorMsg != '')
alert(strErrorMsg)
return false;
}
return true;
}
// Dummy Comment
// 
function jsTrimString(str)
{
	var TestString = str;
	var SpaceChar  = " ";
	while (TestString.charAt(0) == SpaceChar) {TestString = TestString.substr(1)};
	while (TestString.charAt(TestString.length-1) == SpaceChar) {TestString = TestString.substr(0,TestString.length-1)};
	return TestString.toString();
}

function chkEmailList (emailList,strErrorMsg)
{
	var emailList = emailList.toUpperCase( );
	var i = 0;
	var arrEMailList = emailList.split(',');
	for(i = 0; i < arrEMailList.length; i++)
	{
		if(!chkEmail(jsTrimString(arrEMailList[i]),strErrorMsg))
			return false;
	}
	return true;
}