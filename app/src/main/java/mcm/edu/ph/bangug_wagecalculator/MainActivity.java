package mcm.edu.ph.bangug_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editEmployeeName, editHoursRendered;
    RadioGroup rgEmployeeType;
    RadioButton btnSelected;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml IDs for edit texts
        editEmployeeName = findViewById(R.id.editEmployeeName);
        editHoursRendered = findViewById(R.id.editHoursRendered);
        //xml ID for button
        btnCalculate = findViewById(R.id.btnCalculate);
        //xml ID for radio group
        rgEmployeeType = findViewById(R.id.radioGroup);

        btnCalculate.setOnClickListener(this);
    }

    public void onClick(View v){

        if(v.getId() == R.id.btnCalculate) {

            int selectedEmployeeType = rgEmployeeType.getCheckedRadioButtonId();
            btnSelected = findViewById(selectedEmployeeType);

            String employeeName = editEmployeeName.getText().toString();
            String employeeType = btnSelected.getText().toString();
            String hoursRendered = (editHoursRendered.getText().toString());

            Intent DisplayResult = new Intent(this, DisplayResult.class);

            DisplayResult.putExtra("Employee Name", employeeName);
            DisplayResult.putExtra("Employee Type", employeeType);
            DisplayResult.putExtra("Hours Rendered", hoursRendered);

            startActivity(DisplayResult);
        }
    }
}