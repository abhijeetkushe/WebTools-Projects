package com.webtools.springfinal.view;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.bean.MedicineBean;

public class DiagnosisPdfView extends AbstractPdfView {

	private static final String DATE_PATTERN="dd-MMM-yyyy";
	private SimpleDateFormat sdf=new SimpleDateFormat(DATE_PATTERN);
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter pdfwr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		List<DiagnosisBean> diagnosisList = (List<DiagnosisBean>) model
				.get("diagnosisList");
		document.open();

		for(int i=0;i<diagnosisList.size();i++){
		
			DiagnosisBean diagnosis=diagnosisList.get(i);
			if(i==0)
			{
				
				Image image = Image.getInstance(request
						.getRealPath("/images/healthCareletterhead3.JPG"));
				image.setAlignment(Image.ALIGN_TOP);

				image.setWidthPercentage(10);
				image.setSpacingAfter(20);
				PdfPTable imageTable = new PdfPTable(1);

				imageTable.addCell(image);
				imageTable.setSpacingAfter(10);
				imageTable.setWidthPercentage(100);
				document.add(imageTable);
				
				PdfPTable headerTable = new PdfPTable(2);
				headerTable.setSpacingBefore(10);
				headerTable.setSpacingAfter(10);
				PdfPCell cell = new PdfPCell(
						new Paragraph("Appointment Information"));
				cell.setColspan(2);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(new Color(128, 200, 128));
				cell.setPadding(10.0f);
				headerTable.addCell(cell);

				cell = new PdfPCell(new Paragraph("Patient Name"));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(new Color(255, 200, 0));
				cell.setPadding(10.0f);
				headerTable.addCell(cell);
				headerTable.addCell(String.valueOf(diagnosis.getAppointment().getPatientbean().getFullName()));

				cell = new PdfPCell(new Paragraph("Physician Name"));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(new Color(255, 200, 0));
				cell.setPadding(10.0f);
				headerTable.addCell(cell);
				headerTable.addCell(String.valueOf(diagnosis.getAppointment().getPhysician().getFullName()));

				cell = new PdfPCell(new Paragraph("Nature of Illness"));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(new Color(255, 200, 0));
				cell.setPadding(10.0f);
				headerTable.addCell(cell);
				headerTable.addCell(String.valueOf(diagnosis.getAppointment().getNatureOfIllness()));
				
				

				cell = new PdfPCell(new Paragraph("Illness Start Date"));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(new Color(255, 200, 0));
				cell.setPadding(10.0f);
				headerTable.addCell(cell);
				headerTable.addCell(sdf.format(diagnosis.getAppointment().getIllnessStartDate()==null?new Date():diagnosis.getAppointment().getIllnessStartDate()));
				
				cell = new PdfPCell(new Paragraph("Appointment Logged Date"));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(new Color(255, 200, 0));
				cell.setPadding(10.0f);
				headerTable.addCell(cell);
				headerTable.addCell(sdf.format(diagnosis.getAppointment().getCreationDate()==null?new Date():diagnosis.getAppointment().getCreationDate()));
				
				Paragraph dateInformation=new Paragraph("Date of Diagnosis"+sdf.format(diagnosis.getDateDiagnosis()==null?new Date():diagnosis.getDateDiagnosis()));
				dateInformation.setSpacingBefore(10.0f);
				dateInformation.setSpacingAfter(10.0f);
				document.add(dateInformation);
				document.add(headerTable);
			}	
			else
			{
				document.newPage();
				Paragraph dateInformation=new Paragraph("Date of Diagnosis"+sdf.format(diagnosis.getDateDiagnosis()==null?new Date():diagnosis.getDateDiagnosis()));
				dateInformation.setSpacingBefore(20.0f);
				dateInformation.setSpacingAfter(20.0f);
				document.add(dateInformation);
				dateInformation.setAlignment(Element.ALIGN_RIGHT);
			}	
			PdfPTable table = new PdfPTable(2);
			table.setSpacingBefore(20);
			table.setSpacingAfter(20);
			PdfPCell cell = new PdfPCell(
					new Paragraph("Health Record Readings"));
			cell.setColspan(2);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(new Color(128, 200, 128));
			cell.setPadding(10.0f);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph("Weight"));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(new Color(255, 200, 0));
			cell.setPadding(10.0f);
			table.addCell(cell);
			table.addCell(String.valueOf(diagnosis.getWeight()) + " lbs");

			cell = new PdfPCell(new Paragraph("Blood Pressure"));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(new Color(255, 200, 0));
			cell.setPadding(10.0f);
			table.addCell(cell);
			table.addCell(String.valueOf(diagnosis.getBloodPressure()) + " ");

			cell = new PdfPCell(new Paragraph("Pulse"));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(new Color(255, 200, 0));
			cell.setPadding(10.0f);
			table.addCell(cell);
			table.addCell(String.valueOf(diagnosis.getPulse()) + " pulse/min");

			cell = new PdfPCell(new Paragraph("Temperature"));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(new Color(255, 200, 0));
			cell.setPadding(10.0f);
			table.addCell(cell);
			table.addCell(String.valueOf(diagnosis.getTemperature()) + " C");

			PdfPTable medicineTable = new PdfPTable(3);
			PdfPCell cell1 = new PdfPCell(new Paragraph("Medicines Prescribed"));
			cell1.setColspan(3);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(new Color(128, 200, 128));
			cell1.setPadding(10.0f);
			medicineTable.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph("Name"));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(new Color(255, 200, 0));
			cell1.setPadding(10.0f);
			medicineTable.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph("Quantity"));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(new Color(255, 200, 0));
			cell1.setPadding(10.0f);
			medicineTable.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph("Ingredients"));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(new Color(255, 200, 0));
			cell1.setPadding(10.0f);
			medicineTable.addCell(cell1);

			for (MedicineBean medicineBean : diagnosis.getMedicineList()) {
				medicineTable.addCell(String.valueOf(medicineBean
						.getMedicineName()));
				medicineTable.addCell(String.valueOf(medicineBean
						.getQuantityPrescribed()));
				medicineTable.addCell(String.valueOf(medicineBean
						.getMedicineIngredients()));

			}

			Paragraph header = new Paragraph("Health Care Pvt Ltd");
			header.setAlignment(Element.ALIGN_TOP);
			Paragraph address = new Paragraph("Address");


			
			// table.setRunDirection(Element.ALIGN_CENTER);
			// medicineTable.setRunDirection(Element.ALIGN_BOTTOM);

			document.add(table);
			document.add(medicineTable);

		}
		document.close();
	}

}
