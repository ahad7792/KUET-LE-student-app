package abdulahad.imfast.io.lekuetapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import abdulahad.imfast.io.lekuetapp.R;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private ActivityAdapter adapter;
    private List<ActivityModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();

        list.add(new ActivityModel(R.drawable.footwear_cad, "FootwearCAD", "\n" +
                "Footwear CAD is a Footwear designing club where students are trained mainly on virtual Footwear Design.It is an extra curriculum activities club of department of Leather Engineering,KUET.It also creates and provides tutorials and learning materials."));
        list.add(new ActivityModel(R.drawable.prism, "PRISM", "It is a skill development club for making every students ready for the corporate world. Prism is your place to explore the inner potentials hiding inside you with utmost freedom."));
        list.add(new ActivityModel(R.drawable.le_notes, "KUET LE Notes", "The difference between the two-feet is not visual with the human eyes which can define a footwear designer and those designers work with the world's best natural material called leather...\n" +
                "The material of the designer is given here..."));

        adapter = new ActivityAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        return  view;
    }
}