package abdulahad.imfast.io.lekuetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {

    private String[] images;
    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public SliderAdapter(String[] images) {
        this.images = images;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout, null);

        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {

        Glide.with(viewHolder.itemView)
                .load(images[position])
                .fitCenter()
                .into(viewHolder.imageView);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class SliderViewHolder extends SliderViewAdapter.ViewHolder{

        private ImageView imageView;

        public SliderViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.sliderImage);

        }
    }

}
