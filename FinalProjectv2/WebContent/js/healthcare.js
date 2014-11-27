/**
 * @author Admin
 */

$(function() {
	$("#checkUser").click(checkUserName);
});

function checkUserName() {
	var userNameVal = $("#createUser input[name=userAccount.userName]").val();

	$.get("http://localhost:8085/HealthCarev1/ajax/checkUser.html", "username="
			+ userNameVal + "", function(data) {
		if (data == "true") {
			$('#userex').css("display", "inline");
		} else {
			$('#userex').css("display", "none");

		}
	}, "html");

}
function addMed() {
	//var medCount = $('#totalMedCount input[name=totalMedCount]').val();
	var medNameArr = new Array(medCount);
	var medIngArr = new Array(medCount);
	var medQuantArr = new Array(medCount);
	for ( var i = 0; i < medCount; i++) {

		medNameArr[i] = $(
				"#createDiagnosis input[name=medicineList[" + i
						+ "].medicineName]").val();
		medIngArr[i] = $(
				"#createDiagnosis input[name=medicineList[" + i
						+ "].medicineIngredients]").val();
		medQuantArr[i] = $(
				"#createDiagnosis input[name=medicineList[" + i + "].quantity]")
				.val();
	}
	$.get("http://localhost:8085/HealthCarev1/ajax/addMedList.html",
					"medCount=" + medCount + "", function(data) {
						if (data) {
							$('#medList').hide();
							$('#medList').html(data);
							for ( var j = 0; j < medCount; j++) {
								$(
										"#createDiagnosis input[name=medicineList["
												+ j + "].medicineName]").val(
										medNameArr[j]);
								$(
										"#createDiagnosis input[name=medicineList["
												+ j + "].medicineIngredients]")
										.val(medIngArr[j]);
								$(
										"#createDiagnosis input[name=medicineList["
												+ j + "].quantity]").val(
										medQuantArr[j]);

							}
							$('#medList').show();

						}
					}, "html");
	$("#createDiagnosis input[name=totalMedCount]").val(++medCount);

	//${"medList"}.
	return false;
}

function addInsurance() {
	var insCount = $("#createUser input[name=totalInsCount]").val();
	var insNameArr = new Array(insCount);
	var insPolArr = new Array(insCount);
	var insStartArr = new Array(insCount);
	var insEndArr = new Array(insCount);
	for ( var i = 0; i < insCount; i++) {

		insNameArr[i] = $(
				"#createUser input[name=insuranceList[" + i
						+ "].insuranceName]").val();
		insPolArr[i] = $(
				"#createUser input[name=insuranceList[" + i + "].policyName]")
				.val();
		insStartArr[i] = $(
				"#createUser input[name=insuranceList[" + i + "].startDate]")
				.val();
		insEndArr[i] = $(
				"#createUser input[name=insuranceList[" + i + "].endDate]")
				.val();

	}
	$.get("http://localhost:8085/HealthCarev1/ajax/addInsList.html",
			"insCount=" + insCount + "", function(data) {
				if (data) {
					$('#insList').hide();
					$('#insList').html(data);
					for ( var j = 0; j < insCount; j++) {
						$(
								"#createUser input[name=insuranceList[" + j
										+ "].insuranceName]")
								.val(insNameArr[j]);
						$(
								"#createUser input[name=insuranceList[" + j
										+ "].policyName]").val(insPolArr[j]);
						$(
								"#createUser input[name=insuranceList[" + j
										+ "].startDate]").val(insStartArr[j]);
						$(
								"#createUser input[name=insuranceList[" + j
										+ "].endDate]").val(insEndArr[j]);
						

					}
					$('#insList').show();
					for(k=0;k<insCount;k++)
					{
						$('#insuranceList'+k+'.endDate').datepicker();
						$('#insuranceList'+k+'.startDate').datepicker();
					}	

				}
			}, "html");
	$("#createUser input[name=totalInsCount]").val(++insCount);

	//${"medList"}.
	return false;
}

function parseXml(xmlResponse)
{
	if(	showChart)
	{
		$('#tabs').hide();
		showChart=false;
		return false;
	}	
	
	var list = xmlResponse.getElementsByTagName("list")[0];
	var items = list.getElementsByTagName("diagnosis");
	var count=items.length;

	var weigthArr=new Array();
	var pressArr=new Array();
	var pulseArr=new Array();
	var tempArr=new Array();
	
	var date=new Date();
	var currdate=(1+date.getMonth())+'-'+date.getDate()+'-'+date.getFullYear();
	
	var currWeight=parseInt($('#weight').val());
	var currTemp=parseInt($('#temperature').val());
	var currPress=parseInt($('#bloodPressure').val());
	var currPulse=parseInt($('#pulse').val());
	for(i=0;i<count;i++)
	{
		var item=items[i];
		weigthArr[i]=new Array(2);
		pressArr[i]=new Array(2);
		pulseArr[i]=new Array(2);
		tempArr[i]=new Array(2);
			

		weigthArr[i][0] = item.getElementsByTagName("date")[0].firstChild.nodeValue;
		weigthArr[i][1]= parseInt(item.getElementsByTagName("weight")[0].firstChild.nodeValue);
		
		
		pressArr[i][0] = item.getElementsByTagName("date")[0].firstChild.nodeValue;
		pressArr[i][1]= parseInt(item.getElementsByTagName("bloodpressure")[0].firstChild.nodeValue);
		
		pulseArr[i][0] = item.getElementsByTagName("date")[0].firstChild.nodeValue;
		pulseArr[i][1]= parseInt(item.getElementsByTagName("pulse")[0].firstChild.nodeValue);
		
		tempArr[i][0] = item.getElementsByTagName("date")[0].firstChild.nodeValue;
		tempArr[i][1]= parseInt(item.getElementsByTagName("temperature")[0].firstChild.nodeValue);
		
	}
	weigthArr[count]=new Array(2);
	pressArr[count]=new Array(2);
	pulseArr[count]=new Array(2);
	tempArr[count]=new Array(2);
	
	weigthArr[count][0]=currdate;
	weigthArr[count][1]=currWeight;
	
	pressArr[count][0]=currdate;
	pressArr[count][1]=currPress;
	pulseArr[count][0]=currdate;
	pulseArr[count][1]=currPulse;
	tempArr[count][0]=currdate;
	tempArr[count][1]=currTemp;
	
	var dataWeight = new google.visualization.DataTable();
	dataWeight.addColumn('string', 'Date');
	dataWeight.addColumn('number', 'Weight');
	dataWeight.addRows(weigthArr);

	var chartWeight = new google.visualization.LineChart(document
			.getElementById('tabs-1'));
	chartWeight.draw(dataWeight, {
		width : 400,
		height : 240,
		title : 'Weight Graph'
	});

	var dataTemp = new google.visualization.DataTable();
	dataTemp.addColumn('string', 'Date');
	dataTemp.addColumn('number', 'Temperature');
	dataTemp.addRows(tempArr);

	var chartTemp = new google.visualization.Gauge(document
			.getElementById('tabs-2'));
	var options = {
		width : 400,
		height : 120,
		max : 120,
		min : 0,
		minorTicks : 5
	};
	chartTemp.draw(dataTemp, options);

	var dataPressure = new google.visualization.DataTable();
	dataPressure.addColumn('string', 'Date');
	dataPressure.addColumn('number', 'Pulse Rate');
	dataPressure.addRows(pressArr);

	 var chartPressure = new google.visualization.BarChart(document.getElementById('tabs-3'));
	 chartPressure.draw(dataPressure, {width: 400, height: 240, title: 'Blood Pressure',
                       vAxis: {title: 'Date', titleTextStyle: {color: 'red'}}
                      });
	

	var dataPulse = new google.visualization.DataTable();
	dataPulse.addColumn('string', 'Date');
	dataPulse.addColumn('number', 'Pulse Rate');
	dataPulse.addRows(pulseArr);

	var chartPulse = new google.visualization.ColumnChart(document
			.getElementById('tabs-4'));
	chartPulse.draw(dataPulse, {
		width : 400,
		height : 240,
		title : 'Pulse Rate',
		hAxis : {
			title : 'Date',
			titleTextStyle : {
				color : 'red'
			}
		}
	});
	$('#tabs').show();
	showChart=true;
	return false;
}

function drawChart() {

	$.get("http://localhost:8085/HealthCarev1/ajax/getChart.html", "username="
			+"", function(data) {if(data)
			{parseXml(data);}}, "xml");
	
	
}

function submitForm()
{
	$("#createUser input[name=onChange]").click();
}

function getPhysician()
{
	var userNameVal = $("#appointment input[name=physicianName]").val();
	$.get("http://localhost:8085/HealthCarev1/ajax/getPhysician.html",
			"userNameVal=" + userNameVal + "", function(data) {
				if (data) {
					$('#physicianInfo').hide();
					$('#physicianInfo').html(data);
					$('#physicianInfo').show();

				}
			}, "html");
	$('#GetDirections').show();
	
}


function getMap()
{
	var physicianID=$('#appointment input[name=physicianID]').val();
	$.get("http://localhost:8085/HealthCarev1/ajax/getMap.html",
			"userNameVal="+physicianID, function(data) {
				if (data) {
					generateMap(data);
				}
			}, "html");
}

function generateMap(responseXml)
{
	$('#map').html('<iframe src ="/HealthCarev1/test3.jsp" width="600px" height="400px" frameborder="0"> <p>Your browser does not support iframes.</p>'+'</iframe>');
	//responseXml
	/*var list = xmlResponse.getElementsByTagName("list")[0];
	var items = list.getElementsByTagName("diagnosis");
	var count=items.length;*/
	
	
    /*var addressArr=new Array();
    for(i=0;i<2;i++)
    {
    addressArr[0]=new Array(2);
    addressArr[1]=new Array(2);
    	addressArr[0][0]='38 Clearway Street,Apt 1,Boston,MA,02115';
    	addressArr[0][1]='Abhijeet\'s Place';
    	
    	addressArr[1][0]='360 Huntington Ave,Boston,MA,02115';
    	addressArr[1][1]='Doctor\'s Clinic';
    }
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'address');
    data.addColumn('string', 'Name');
    data.addRows(addressArr);
    var map = new google.visualization.Map(document.getElementById('map'));
    map.draw(data, {showTip: true,showLine:true,enableScrollWheel:true,useMapTypeControl:true});
	var data = new google.visualization.DataTable();
    data.addColumn('number', 'Lat');
    data.addColumn('number', 'Lon');
    data.addColumn('string', 'Name');
    data.addRows(4);
    data.setCell(0, 0, 37.4232);
    data.setCell(0, 1, -122.0853);
    data.setCell(0, 2, 'Work');
    data.setCell(1, 0, 37.4289);
    data.setCell(1, 1, -122.1697);
    data.setCell(1, 2, 'University');
    data.setCell(2, 0, 37.6153);
    data.setCell(2, 1, -122.3900);
    data.setCell(2, 2, 'Airport');
    data.setCell(3, 0, 37.4422);
    data.setCell(3, 1, -122.1731);
    data.setCell(3, 2, 'Shopping');

    var map = new google.visualization.Map(document.getElementById('map'));
    map.draw(data, {showTip: true});
*/     
}
