package abdulahad.imfast.io.lekuetapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import abdulahad.imfast.io.lekuetapp.R;

public class FacultyFragment extends Fragment {

    private RecyclerView leProfessor, leAssociates, assistantProf, leLecturer;
    private LinearLayout professorNoData, associateNoData, assistantProfNoData, lecturerNodata;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;

    private ProgressBar progressBar1, progressBar2, progressBar3, progressBar4;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        professorNoData = view.findViewById(R.id.professorNoData);
        associateNoData = view.findViewById(R.id.associateNoData);
        assistantProfNoData = view.findViewById(R.id.assistantProfNoData);
        lecturerNodata = view.findViewById(R.id.lecturerNodata);

        leProfessor = view.findViewById(R.id.leProfessor);
        leAssociates = view.findViewById(R.id.leAssociates);
        assistantProf = view.findViewById(R.id.assistantProf);
        leLecturer = view.findViewById(R.id.leLecturer);

        progressBar1 = view.findViewById(R.id.progress_circle1);
        progressBar2 = view.findViewById(R.id.progress_circle2);
        progressBar3 = view.findViewById(R.id.progress_circle3);
        progressBar4 = view.findViewById(R.id.progress_circle4);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        professors();
        associateProfessors();
        assistantProfessors();
        lecturers();

        return view;
    }

    private void professors() {

        dbRef = reference.child("Professor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    professorNoData.setVisibility(View.VISIBLE);
                    leProfessor.setVisibility(View.GONE);

                    //progressBar1.setVisibility(View.INVISIBLE);
                }else {
                    professorNoData.setVisibility(View.GONE);
                    leProfessor.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    leProfessor.setHasFixedSize(true);
                    leProfessor.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    leProfessor.setAdapter(adapter);

                    progressBar1.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(),Toast.LENGTH_SHORT).show();

                progressBar1.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void associateProfessors() {

        dbRef = reference.child("Associate Professor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()){
                    associateNoData.setVisibility(View.VISIBLE);
                    leAssociates.setVisibility(View.GONE);

                    //progressBar2.setVisibility(View.INVISIBLE);
                }else {
                    associateNoData.setVisibility(View.GONE);
                    leAssociates.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    leAssociates.setHasFixedSize(true);
                    leAssociates.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    leAssociates.setAdapter(adapter);

                    progressBar2.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(),Toast.LENGTH_SHORT).show();

                progressBar2.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void assistantProfessors() {

        dbRef = reference.child("Assistant Professor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                    assistantProfNoData.setVisibility(View.VISIBLE);
                    assistantProf.setVisibility(View.GONE);

                    //progressBar3.setVisibility(View.INVISIBLE);
                }else {
                    assistantProfNoData.setVisibility(View.GONE);
                    assistantProf.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    assistantProf.setHasFixedSize(true);
                    assistantProf.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    assistantProf.setAdapter(adapter);

                    progressBar3.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(),Toast.LENGTH_SHORT).show();

                progressBar3.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void lecturers() {

        dbRef = reference.child("Lecturer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    lecturerNodata.setVisibility(View.VISIBLE);
                    leLecturer.setVisibility(View.GONE);

                    //progressBar4.setVisibility(View.INVISIBLE);
                }else {
                    lecturerNodata.setVisibility(View.GONE);
                    leLecturer.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    leLecturer.setHasFixedSize(true);
                    leLecturer.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    leLecturer.setAdapter(adapter);

                    progressBar4.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(),Toast.LENGTH_SHORT).show();

                progressBar4.setVisibility(View.INVISIBLE);
            }
        });

    }
}