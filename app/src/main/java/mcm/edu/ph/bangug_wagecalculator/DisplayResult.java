package mcm.edu.ph.bangug_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayResult extends AppCompatActivity implements View.OnClickListener {

    TextView txtEmployeeName, txtEmployeeType, txtHoursRendered, txtOTHoursRendered, txtRegularWage, txtOTWage, txtTotalWage;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        //xml IDs for text views
        txtEmployeeName = findViewById(R.id.txtEmployeeName);
        txtEmployeeType = findViewById(R.id.txtEmployeeType);
        txtHoursRendered = findViewById(R.id.txtHoursRendered);
        txtOTHoursRendered = findViewById(R.id.txtOTHoursRendered);
        txtRegularWage = findViewById(R.id.txtRegularWage);
        txtOTWage = findViewById(R.id.txtOTWage);
        txtTotalWage = findViewById(R.id.txtTotalWage);
        //xml ID for button
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(this);


        Intent MainActivity = getIntent();

        String employeeName = MainActivity.getStringExtra("Employee Name");
        String employeeType = MainActivity.getStringExtra("Employee Type");
        Double hoursRendered = Double.parseDouble(MainActivity.getStringExtra("Hours Rendered"));

        txtEmployeeName.setText("Employee Name: " +employeeName);
        txtEmployeeType.setText("Employee Type: " +employeeType);
        txtHoursRendered.setText("Hours Rendered: " +String.valueOf(hoursRendered)+ " hours");

        double totalWage = 0.0;
        double otWage = 0.0;
        double otHours = 0.0;

        calcWage(employeeType,hoursRendered,totalWage,otWage,otHours);
    }

    public void calcWage(String employeeType,double hoursRendered,double totalWage,double otWage,double otHours){

        if (hoursRendered <= 8){
            if (employeeType.equals("Full-time")){
                totalWage = hoursRendered * 100;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtOTWage.setText("OT Wage: ₱0.0");
                txtRegularWage.setText("Regular Wage: ₱" +String.valueOf(totalWage));
                txtOTHoursRendered.setText("OT Hours Rendered: 0 hour");
            }
            else if (employeeType.equals("Probationary")){
                totalWage = hoursRendered * 90;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtOTWage.setText("OT Wage: ₱0.0");
                txtRegularWage.setText("Regular Wage: ₱" +String.valueOf(totalWage));
                txtOTHoursRendered.setText("OT Hours Rendered: 0 hour");
            }
            else {
                totalWage = hoursRendered * 75;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtOTWage.setText("OT Wage: ₱0.0");
                txtRegularWage.setText("Regular Wage: ₱" +String.valueOf(totalWage));
                txtOTHoursRendered.setText("OT Hours Rendered: 0 hour");
            }
        }
        else {
            if (employeeType.equals("Full-time")){
                totalWage = 800 + (115 * (hoursRendered - 8.0));
                otWage = 115 * (hoursRendered - 8.0);
                otHours = hoursRendered - 8.0;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtOTWage.setText("OT Wage: ₱" +String.valueOf(otWage));
                txtRegularWage.setText("Regular Wage: ₱800.0");
                txtOTHoursRendered.setText("OT Hours Rendered: " +String.valueOf(otHours)+ " hours");
            }
            else if (employeeType.equals("Probationary")){
                totalWage = 720 + (100 * (hoursRendered - 8.0));
                otWage = 100 * (hoursRendered - 8.0);
                otHours = hoursRendered - 8.0;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtOTWage.setText("OT Wage: ₱" +String.valueOf(otWage));
                txtRegularWage.setText("Regular Wage: ₱720.0");
                txtOTHoursRendered.setText("OT Hours Rendered: " +String.valueOf(otHours)+ " hours");
            }
            else {
                totalWage = 600 + (90 * (hoursRendered - 8.0));
                otWage = 90 * (hoursRendered - 8.0);
                otHours = hoursRendered - 8.0;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtOTWage.setText("OT Wage: ₱" +String.valueOf(otWage));
                txtRegularWage.setText("Regular Wage: ₱600.0");
                txtOTHoursRendered.setText("OT Hours Rendered: " +String.valueOf(otHours)+ " hours");
            }
        }
    }

    public void onClick(View v){
        if (v.getId() == R.id.btnBack){
            startActivity(new Intent(this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}