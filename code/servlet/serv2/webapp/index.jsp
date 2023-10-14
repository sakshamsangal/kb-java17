<%@ page import="com.saksham.Crud" %>
<%@ page import="java.util.List" %>
<%@ page import="com.saksham.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Covid 19</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">

</head>
<body>

<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
    <a class="navbar-brand" href="#">Covid-19</a>
</nav>
<%
    // Student student = (Student) request.getAttribute("student");
    // String studentRollNumber = "";
    // String studentName = "";
    // if (student != null) {
    //     studentRollNumber = String.valueOf(student.getRollNumber());
    //     studentName = student.getStudentName();
    // }

    Patient patient = (Patient) request.getAttribute("patient");
    String id = "";
    String patient_name = "";
    String pr = "";
    String bp_systolic = "";
    String bp_diastolic = "";
    String temp = "";
    String rr = "";
    String spo2 = "";
    String o2 = "";
    String fio2 = "";
    String other = "";
    String remarks = "";
    String gcs = "";
    String urine = "";
    String inotrope = "";
    String position = "";
    String Intake = "";
    String Steroids = "";
    String Antibiotics = "";
    String Clexane = "";


    if (patient != null) {

        id = String.valueOf(patient.getId());
        patient_name = patient.getPatient_name();
        pr = String.valueOf(patient.getPr());
        bp_systolic = String.valueOf(patient.getBp_systolic());
        bp_diastolic = String.valueOf(patient.getBp_diastolic());
        temp = String.valueOf(patient.getTemp());
        rr = String.valueOf(patient.getRr());
        spo2 = String.valueOf(patient.getSpo2());
        o2 = String.valueOf(patient.getO2());
        fio2 = String.valueOf(patient.getFio2());
        other = patient.getOther();
        remarks = patient.getRemarks();
        gcs = String.valueOf(patient.getGcs());
        urine = String.valueOf(patient.getUrine());
        inotrope = patient.getInotrope();
        position = patient.getPosition();
        Intake = patient.getIntake();
        Steroids = patient.getSteroids();
        Antibiotics = patient.getAntibiotics();
        Clexane = patient.getClexane();


    }
%>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3" style="overflow: scroll;height:600px " >
            <h2>Patient parameters</h2>
            <div>
                <form action="/crud" method="post">


                    <div class="form-group">
                        <label>id:</label>
                        <input class="form-control" value="<%=id%>" type="text" name="id" placeholder="Enter id">
                    </div>

                    <div class="form-group">
                        <label>patient_name:</label>
                        <input class="form-control" value="<%=patient_name%>" type="text" name="patient_name"
                               placeholder="Enter patient_name">
                    </div>

                    <div class="form-group">
                        <label>pr:</label>
                        <input class="form-control" value="<%=pr%>" type="text" name="pr" placeholder="Enter pr">
                    </div>

                    <div class="form-group">
                        <label>bp_systolic:</label>
                        <input class="form-control" value="<%=bp_systolic%>" type="text" name="bp_systolic"
                               placeholder="Enter bp_systolic">
                    </div>

                    <div class="form-group">
                        <label>bp_diastolic:</label>
                        <input class="form-control" value="<%=bp_diastolic%>" type="text" name="bp_diastolic"
                               placeholder="Enter bp_diastolic">
                    </div>

                    <div class="form-group">
                        <label>temp:</label>
                        <input class="form-control" value="<%=temp%>" type="text" name="temp" placeholder="Enter temp">
                    </div>

                    <div class="form-group">
                        <label>rr:</label>
                        <input class="form-control" value="<%=rr%>" type="text" name="rr" placeholder="Enter rr">
                    </div>

                    <div class="form-group">
                        <label>spo2:</label>
                        <input class="form-control" value="<%=spo2%>" type="text" name="spo2" placeholder="Enter spo2">
                    </div>

                    <div class="form-group">
                        <label>o2:</label>
                        <input class="form-control" value="<%=o2%>" type="text" name="o2" placeholder="Enter o2">
                    </div>

                    <div class="form-group">
                        <label>fio2:</label>
                        <input class="form-control" value="<%=fio2%>" type="text" name="fio2" placeholder="Enter fio2">
                    </div>

                    <div class="form-group">
                        <label>other:</label>
                        <input class="form-control" value="<%=other%>" type="text" name="other" placeholder="Enter other">
                    </div>

                    <div class="form-group">
                        <label>remarks:</label>
                        <input class="form-control" value="<%=remarks%>" type="text" name="remarks" placeholder="Enter remarks">
                    </div>

                    <div class="form-group">
                        <label>gcs:</label>
                        <input class="form-control" value="<%=gcs%>" type="text" name="gcs" placeholder="Enter gcs">
                    </div>

                    <div class="form-group">
                        <label>urine:</label>
                        <input class="form-control" value="<%=urine%>" type="text" name="urine" placeholder="Enter urine">
                    </div>

                    <div class="form-group">
                        <label>inotrope:</label>
                        <input class="form-control" value="<%=inotrope%>" type="text" name="inotrope"
                               placeholder="Enter inotrope">
                    </div>

                    <div class="form-group">
                        <label>position:</label>
                        <input class="form-control" value="<%=position%>" type="text" name="position"
                               placeholder="Enter position">
                    </div>

                    <div class="form-group">
                        <label>Intake:</label>
                        <input class="form-control" value="<%=Intake%>" type="text" name="Intake" placeholder="Enter Intake">
                    </div>

                    <div class="form-group">
                        <label>Steroids:</label>
                        <input class="form-control" value="<%=Steroids%>" type="text" name="Steroids"
                               placeholder="Enter Steroids">
                    </div>

                    <div class="form-group">
                        <label>Antibiotics:</label>
                        <input class="form-control" value="<%=Antibiotics%>" type="text" name="Antibiotics"
                               placeholder="Enter Antibiotics">
                    </div>

                    <div class="form-group">
                        <label>Clexane:</label>
                        <input class="form-control" value="<%=Clexane%>" type="text" name="Clexane" placeholder="Enter Clexane">
                    </div>



                    <button class="btn btn-primary float-right" name="save" value="save">Save</button>
                    <br>
                    <br>

                </form>
            </div>
        </div>
        <div class="col-sm-9" style="overflow: scroll;height:600px ">

            <br>
            <table id="table_id" class="display">

                <thead>
                <tr>
                    <th>Id</th>
                    <th>Patient_name</th>
                    <th>Pr</th>
                    <th>Bp_systolic</th>
                    <th>Bp_diastolic</th>
                    <th>Temp</th>
                    <th>Rr</th>
                    <th>Spo2</th>
                    <th>O2</th>
                    <th>Fio2</th>
                    <th>Other</th>
                    <th>Remarks</th>
                    <th>Gcs</th>
                    <th>Urine</th>
                    <th>Inotrope</th>
                    <th>Position</th>
                    <th>Intake</th>
                    <th>Steroids</th>
                    <th>Antibiotics</th>
                    <th>Clexane</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Patient> patients = Crud.view();
                    for (int i = 0; i < patients.size(); i++) { %>
                <tr>
                    <td><%=patients.get(i).getId()%></td>
                    <td><%=patients.get(i).getPatient_name()%></td>
                    <td><%=patients.get(i).getPr()%></td>
                    <td><%=patients.get(i).getBp_systolic()%></td>
                    <td><%=patients.get(i).getBp_diastolic()%></td>

                    <td><%=patients.get(i).getTemp()%></td>
                    <td><%=patients.get(i).getRr()%></td>
                    <td><%=patients.get(i).getSpo2()%></td>
                    <td><%=patients.get(i).getO2()%></td>
                    <td><%=patients.get(i).getFio2()%></td>

                    <td><%=patients.get(i).getOther()%></td>
                    <td><%=patients.get(i).getRemarks()%></td>
                    <td><%=patients.get(i).getGcs()%></td>
                    <td><%=patients.get(i).getUrine()%></td>
                    <td><%=patients.get(i).getInotrope()%></td>

                    <td><%=patients.get(i).getPosition()%></td>
                    <td><%=patients.get(i).getIntake()%></td>
                    <td><%=patients.get(i).getSteroids()%></td>
                    <td><%=patients.get(i).getAntibiotics()%></td>
                    <td><%=patients.get(i).getClexane()%></td>
                </tr>
                <%
                    }
                    if (patients.size() < 1) {
                        out.print("No records available");
                    }
                %>
                </tbody>
            </table>

        </div>
    </div>
</div>


<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>

<script>
    $(document).ready(function () {
        $('#table_id').DataTable();
    });

</script>
</body>
</html>
