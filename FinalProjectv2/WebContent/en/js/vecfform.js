function checkssn(object_value, required) // originally based on cfform.js function _CF_checkssc
{	
	var ssc_string="";
	var arr;
	var ssnp1;
	var ssnp2;
	var ssnp3;
	
	if (object_value.length == 0) {
		return ( required ) ? false : true;
	}
	else if (object_value.length == 11) {	
		arr = object_value.split('-');	
		if ( arr.length != 3 )
			return false;	
			
		ssc_string = arr[0]+arr[1]+arr[2];
	}
	else if (object_value.length == 9) {
		ssc_string = object_value;
		arr = new Array(3);
		arr[0] = object_value.slice(0,3);
		arr[1] = object_value.slice(3,5);
		arr[2] = object_value.slice(5,9);
	}
	else
		return false;
	
	if (ssc_string.length != 9)
		return false;

	if (!checkinteger(ssc_string))
		return false;

	// additional ssn checking - see verts 58868
	ssnp1 = arr[0];
	ssnp2 = arr[1];
	ssnp3 = arr[2];
	if ( ssnp1.length != 3 || ssnp1 == '000'  || ssnp1 == '666' || parseInt(ssnp1) > 772 ||
		 ssnp2.length != 2 || ssnp2 == '00'   ||
		 ssnp3.length != 4 || ssnp3 == '0000'
	) return false;

	return true;
}

function checkinteger(object_value, required) // based on cfform.js function _CF_checkinteger
{
	var numPat= /^\d*$/;
	var matchArray=object_value.match(numPat);
	
	if (object_value.length == 0)
		return ( required ) ? false : true;

	if(matchArray==null)
	{
		return false;
	}
	return true;
	/*var decimal_format = ".";
	var check_char = object_value.indexOf(decimal_format);

	if (check_char == -1)
		return checknumber(object_value);
	else
		return false;
		*/
}

function checknumber(object_value, required) // based on cfform.js function _CF_checknumber
{
	if (object_value.length == 0)
		return ( required ) ? false : true;

	var start_format = " .+-0123456789";
	var number_format = " .0123456789";
	var check_char;
	var decimal = false;
	var trailing_blank = false;
	var digits = false;

	check_char = start_format.indexOf(object_value.charAt(0));

	if (check_char == 1)
		decimal = true;
	else if (check_char < 1)
		return false;

	for (var i = 1; i < object_value.length; i++)
	{
		check_char = number_format.indexOf(object_value.charAt(i));
		if (check_char < 0)
			return false;
		else if (check_char == 1)
		{
			if (decimal)
				return false;
			else
				decimal = true;
		}
		else if (check_char == 0)
		{
			if (decimal || digits)	
				trailing_blank = true;
		}
		else if (trailing_blank)
			return false;
		else
			digits = true;
	}	

	return true
}

function checkdate(object_value, required) // based on cfform.js function _CF_checkdate
{	
	if (object_value.length == 0 || object_value == '0/0/0')
		return ( required ) ? false : true;

	isplit = object_value.indexOf('/');

	if (isplit == -1 || isplit == object_value.length)
		return false;

	sMonth = object_value.substring(0, isplit);

	if (sMonth.length == 0)
		return false;

	isplit = object_value.indexOf('/', isplit + 1);

	if (isplit == -1 || (isplit + 1 ) == object_value.length)
		return false;

	sDay = object_value.substring((sMonth.length + 1), isplit);

	if (sDay.length == 0)
		return false;

	sYear = object_value.substring(isplit + 1);

	if (!checkinteger(sMonth,required))
		return false;
	else if (!checkrange(sMonth, 1, 12,required))
		return false;
	else if (!checkinteger(sYear))
		return false;
	else if (!checkrange(sYear, 0, 9999,required))
		return false;
	else if (!checkinteger(sDay,required))
		return false;
	else if (!checkday(sYear, sMonth, sDay,required))
		return false;
	else
		return true;
}

function checkday(checkYear, checkMonth, checkDay, required) // based on cfform.js function
{
	maxDay = 31;

	if (checkMonth == 4 || checkMonth == 6 ||
		checkMonth == 9 || checkMonth == 11)
		maxDay = 30;
	else if (checkMonth == 2)
	{
		if (checkYear % 4 > 0)
			maxDay =28;
		else if (checkYear % 100 == 0 && checkYear % 400 > 0)
			maxDay = 28;
		else
			maxDay = 29;
	}

	return checkrange(checkDay, 1, maxDay, required);
}

function numberrange(object_value, min_value, max_value, required) // based on cfform.js function
{
	if (min_value != null)
	{
		if (object_value < min_value)
			return false;
	}

	if (max_value != null)
	{
		if (object_value > max_value)
			return false;
	}

	return true;
}

function checkrange(object_value, min_value, max_value, required) // based on cfform.js function
{
	if (object_value.length == 0)
		return ( required ) ? false : true;

	if (!checknumber(object_value))
		return false;
	else
		return (numberrange((eval(object_value)), min_value, max_value));

	return true;
}

function checkBankAccountNumber(object_value, required) {
	if (object_value.length == 0)
		return ( required ) ? false : true;
	
	return ( object_value.length < 6 ) ? false : true; 
}

function checkBankRoutingNumber(object_value, required) {
	if (object_value.length == 0)
		return ( required ) ? false : true;
		
	if (object_value.length == 9 ){
		return checkinteger(object_value,required);
	}
	return false;	
}

function determineAge(birth_date) {
	// assumes valid date - returns NaN if invalid
	var now = new Date();
	var bd = ( typeof(birth_date)=='string' ) ? new Date(birth_date) : birth_date ;
		
	return now.getUTCFullYear() - new Date(bd).getUTCFullYear() - 
		(
			(
				( now.getUTCMonth() > bd.getUTCMonth() ) ? 0 : (					
					(						
						( now.getUTCMonth() == bd.getUTCMonth() ) ? (							
							(							
								( now.getUTCDate() >= bd.getUTCDate() ) ? 0 : 1							
							)
				 		) : 1
					)					
				)				
			)
		) ;
}
