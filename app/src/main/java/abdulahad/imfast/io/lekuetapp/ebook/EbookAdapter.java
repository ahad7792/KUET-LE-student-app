package abdulahad.imfast.io.lekuetapp.ebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import abdulahad.imfast.io.lekuetapp.R;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {

    private Context context;
    private List<EbookData> list;

    public EbookAdapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout, parent, false);

        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookAdapter.EbookViewHolder holder, int position) {

        holder.ebookName.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, PdfViewerActivity.class);
                intent.putExtra("pdfUrl", list.get(position).getPdfUrl());
                context.startActivity(intent);

            }
        });

        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                Uri webpage = Uri.parse(list.get(position).getPdfUrl());

                if (!list.get(position).getPdfUrl().startsWith("http://") && !list.get(position).getPdfUrl().startsWith("https://")) {
                    webpage = Uri.parse("http://" + list.get(position).getPdfUrl());
                }
                intent.setData(webpage);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {

        TextView ebookName;
        ImageView ebookDownload;

        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookName = itemView.findViewById(R.id.ebookName);
            ebookDownload = itemView.findViewById(R.id.ebookDownload);
        }
    }
}