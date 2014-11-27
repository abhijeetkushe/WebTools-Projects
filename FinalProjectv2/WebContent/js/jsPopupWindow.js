var popupWin2 = '';

function sizeNamedPopUp(url, pName, windowheight, windowwidth, pAllowResize)
{
	if (!popupWin2.closed && popupWin2.location)
	{
		window.popupWin2.close ();
	}
	var strwindow = "toolbar=No,location=No,directories=No,status=Yes,menubar=No,scrollbars=Yes,resizable=" + pAllowResize + ",width=" + windowwidth + ",height=" + windowheight;
	popupWin2 = window.open(url, pName, strwindow);
	if (!popupWin2.opener) popupWin2.opener = self;
	if (window.focus) {popupWin2.focus()}
}

function popup(myLink,evalwindow)
{
	if(! window.focus)
		return;

	var myWin=window.open("",evalwindow,"toolbar=0,menubar=0,resizable=yes,scrollbars=yes,width=800,height=600");
	myWin.focus();
	myLink.target=evalwindow;
}

function MouseLocationPopup(myLink,event,xsize,ysize,name)
{
	if (!window.focus)
		return;
	if(name=='')
	{
		name='Help';
	}
	var lcWidth = "width=" + xsize;
	var lcHeight = "height=" + ysize;
	var lcLeft = event.screenX;
	var lcTop = event.screenY - ysize - 24;
	var lcWindowString = "left=" + lcLeft + ",top=" + lcTop + "screenX=" + lcLeft + ",screenY=" + lcTop +",toolbar=0,menubar=0,resizable=yes,scrollbars=yes," + lcWidth + "," + lcHeight;
	var myWin=window.open(myLink, name, lcWindowString);
	myWin.focus();
}

function sizepopup(url, windowheight, windowwidth, pAllowResize, pShowToolbar)
{
	var strwindow = "toolbar=" + pShowToolbar + " ,location=No,directories=No,status=Yes,menubar=No,scrollbars=Yes,resizable=" + pAllowResize + ",width=" + windowwidth + ",height=" + windowheight;
	var popupWin = window.open(url, 'sizepopup', strwindow)
	popupWin.focus();
}

function noOp()
{
}

// Please leave these comments as they prevent JavaScript functions from running together in Netscape!
// End of Date Validation Functions

