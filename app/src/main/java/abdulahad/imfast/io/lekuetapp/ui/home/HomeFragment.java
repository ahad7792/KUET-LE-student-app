package abdulahad.imfast.io.lekuetapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


import abdulahad.imfast.io.lekuetapp.R;
import abdulahad.imfast.io.lekuetapp.SliderAdapter;

public class HomeFragment extends Fragment {

    private String[] images;

    private SliderAdapter adapter;

    private SliderView sliderView;

    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.sliderView);
        sliderView.setSliderAdapter(new SliderAdapter(getActivity()));

        images = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/le-kuet-app.appspot.com/o/sliderImages%2F01.jpg?alt=media&token=9119bd7f-30a9-424e-9085-3712a2171cfd",
                "https://firebasestorage.googleapis.com/v0/b/le-kuet-app.appspot.com/o/sliderImages%2F02.jpg?alt=media&token=eb7af689-b886-46d9-9d67-bdb36437ff3e",
                "https://firebasestorage.googleapis.com/v0/b/le-kuet-app.appspot.com/o/sliderImages%2F05.jfif?alt=media&token=daa48f54-79ad-47b1-be16-1edfcafdc497",
                "https://firebasestorage.googleapis.com/v0/b/le-kuet-app.appspot.com/o/sliderImages%2F06.jpg?alt=media&token=a0f18aae-09d0-44fa-b6ff-6ad6f49c0759",
                "https://firebasestorage.googleapis.com/v0/b/le-kuet-app.appspot.com/o/sliderImages%2F11.jfif?alt=media&token=1b82feff-4552-4c75-b2d6-38a659261839"};

        adapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(adapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {

        Uri uri =Uri.parse("geo:0, 0?q=Department of Leather Engineering, KUET");

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);

    }

}