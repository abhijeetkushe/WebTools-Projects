	function showList(pDataDictionaryFieldID, pPopupFormName, pControlName)
	{
		if (typeof(pPopupFormName) == "undefined")
		{
			pPopupFormName	= "frmLookup";
		}

		// pControlName was added on 3/30/2006.  Most calls to showList will NOT contain an
		// overriding control name.  This change was introduced for PopUp search on OFCCP
		// search which uses a different control name than the field as specififed in the DD.
		if (typeof(pControlName) == "undefined")
		{
			pControlName	= "";
		}
			
		if (typeof(sList) != "object")
		{
			sList = window.open("index.cfm?FuseAction=DSPLookupMasterTable&pFormName=" + pPopupFormName + "&pControlType=2&pDataDictionaryFieldID=" + pDataDictionaryFieldID + "&pControl=" + pControlName, "List", "width=450,height=400,scrollbars=1");
		} 
		else 
		{
			if (!sList.closed)
			{ 
				sList.location.href = "index.cfm?FuseAction=DSPLookupMasterTable&pFormName=" + pPopupFormName + "&pControlType=2&pDataDictionaryFieldID=" + pDataDictionaryFieldID;
			}
			else 
			{
				sList = window.open("index.cfm?FuseAction=DSPLookupMasterTable&pFormName=" + pPopupFormName + "&pControlType=2&pDataDictionaryFieldID=" + pDataDictionaryFieldID + "&pControl=" + pControlName, "List", "width=450,height=400,scrollbars=1");
			}
		}
		sList.focus();
	}

	function remLink()
	{
	  	if (window.sList && window.sList.open && !window.sList.closed)
		   	window.sList.opener = null;
	}
	// [start] Ravi S Veluvali: 1-April-2008: Added for new Control Type (Popup MultiSelect) window
	function showList13(pDataDictionaryFieldID, pLinkFieldValue, pControlName, pPopupFormName)
	{

		if (typeof(pPopupFormName) == "undefined")
		{
			pPopupFormName	= "frmLookup";
		}
				
		if (typeof(sList) != "object")
		{
			sList = window.open("index.cfm?FuseAction=DSPPopupSearchToPopulateMultiSelectControls&pFormName=" + pPopupFormName + "&pControlType=13&pControlName=" + pControlName + "&pDataDictionaryFieldID=" + pDataDictionaryFieldID + "&pLinkFieldValue=" + pLinkFieldValue , "List", "width=450,height=480");
		} 
		else 
		{
			if (!sList.closed)
			{ 
				sList.location.href = "index.cfm?FuseAction=DSPPopupSearchToPopulateMultiSelectControls&pFormName=" + pPopupFormName + "&pControlType=13&pControlName=" + pControlName + "&pDataDictionaryFieldID=" + pDataDictionaryFieldID + "&pLinkFieldValue=" + pLinkFieldValue ;
			}
			else 
			{
				sList = window.open("index.cfm?FuseAction=DSPPopupSearchToPopulateMultiSelectControls&pFormName=" + pPopupFormName + "&pControlType=13&pControlName=" + pControlName + "&pDataDictionaryFieldID=" + pDataDictionaryFieldID + "&pLinkFieldValue=" + pLinkFieldValue , "List", "width=450,height=480");
			}
		}
		sList.focus();
	}
	// [end] Ravi S Veluvali: 1-April-2008: Added for new Control Type (Popup MultiSelect) window
		
	function showList11(pDataDictionaryFieldID, pLinkFieldValue, pPopupFormName, pControlName)
	{
		if (typeof(pControlName) == "undefined")
		{
			pControlName	= "";
		}
		if (typeof(pPopupFormName) == "undefined")
		{
			pPopupFormName	= "frmLookup";
		}
				
		if (typeof(sList) != "object")
		{
			sList = window.open("index.cfm?FuseAction=DSPLookupMasterTableForDrivenField&pFormName=" + pPopupFormName + "&pControlType=11&pDataDictionaryFieldID=" + pDataDictionaryFieldID + "&pLinkFieldValue=" + pLinkFieldValue + "&pControl=" + pControlName, "List", "width=450,height=400,scrollbars=1");
		} 
		else 
		{
			if (!sList.closed)
			{ 
				sList.location.href = "index.cfm?FuseAction=DSPLookupMasterTableForDrivenField&pFormName=" + pPopupFormName + "&pControlType=11&pDataDictionaryFieldID=" + pDataDictionaryFieldID + "&pLinkFieldValue=" + pLinkFieldValue + "&pControl=" + pControlName;
			}
			else 
			{
				sList = window.open("index.cfm?FuseAction=DSPLookupMasterTableForDrivenField&pFormName=" + pPopupFormName + "&pControlType=11&pDataDictionaryFieldID=" + pDataDictionaryFieldID + "&pLinkFieldValue=" + pLinkFieldValue + "&pControl=" + pControlName, "List", "width=450,height=400,scrollbars=1");
			}
		}
		sList.focus();
	}
