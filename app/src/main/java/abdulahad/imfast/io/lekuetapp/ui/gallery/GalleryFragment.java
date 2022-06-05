package abdulahad.imfast.io.lekuetapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import abdulahad.imfast.io.lekuetapp.R;

public class GalleryFragment extends Fragment {

    RecyclerView indstourRecycler, seminarRecycler, eventsRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        indstourRecycler = view.findViewById(R.id.indstourRecycler);
        seminarRecycler = view.findViewById(R.id.seminarRecycler);
        eventsRecycler = view.findViewById(R.id.eventsRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getIndstourImage();

        getSeminarImage();

        getEventImage();

        return view;
    }

    private void getIndstourImage() {

        reference.child("Industrial Tour").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String data = dataSnapshot.getValue().toString();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                indstourRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                indstourRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void getSeminarImage() {

        reference.child("Seminars").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String data = dataSnapshot.getValue().toString();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                seminarRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                seminarRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void getEventImage() {

        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String data = dataSnapshot.getValue().toString();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                eventsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                eventsRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}