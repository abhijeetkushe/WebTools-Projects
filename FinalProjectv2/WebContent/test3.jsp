<!--<html>
  <head>
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["map"]});
      google.setOnLoadCallback(drawMap);
      function drawMap() {
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

        var map = new google.visualization.Map(document.getElementById('map_div'));
        map.draw(data, {showTip: true});
      }
    </script>
  </head>

  <body>
    <div id="map_div" style="width: 400px; height: 300px"></div>
  </body>
</html>-->

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html>
  <head>
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
     patientName='<c:out value="${patientName}"/>';
     patientLat=<c:out value="${patientLat}"/>;
     patientLong=<c:out value="${patientLong}"/>;
     patientLoc='<c:out value="${patientLoc}"/>';
     
     physicianName='<c:out value="${physicianName}"/>';
     physicianLat=<c:out value="${physicianLat}"/>;
     physicianLong=<c:out value="${physicianLong}"/>;
     pysicianLoc='<c:out value="${physicianLoc}"/>';
    
      google.load("visualization", "1", {packages:["map"]});
      google.setOnLoadCallback(drawMap);
      function drawMap() {
        
					
					
			        var addressArr=new Array();
			        /* for(i=0;i<2;i++)
			         {*/
			         addressArr[0]=new Array(3);
			         addressArr[1]=new Array(3); 
			         
		          	 addressArr[0][0]=patientLat;
				     addressArr[0][1]=patientLong;
				     addressArr[0][2]=patientName+'\n'+patientLoc;
			         	
			         addressArr[1][0]= physicianLat;
			         addressArr[1][1]=physicianLong;			         
			         addressArr[1][2]=physicianName+'\n'+pysicianLoc;
			         
			         var data = new google.visualization.DataTable();
			         
			         data.addColumn('number', 'Lat');
			         data.addColumn('number', 'Lon');
			         data.addColumn('string', 'Name');
			         
			         data.addRows(addressArr);

			         var map = new google.visualization.Map(document.getElementById('map_div'));
			         map.draw(data, {showTip: true,showLine:true,enableScrollWheel:true,useMapTypeControl:true,mapType:'normal'});
				      

      }
    </script>
  </head>

  <body>
    <div id="map_div" style="width: 400px; height: 300px"></div>
  </body>
</html>