package com.example.thenote.fragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thenote.R;
import com.example.thenote.models.NoteImage;

import java.util.ArrayList;
import java.util.List;

public class NoteImageAdapter extends RecyclerView.Adapter<NoteImageAdapter.ImageViewHolder> {

    private List<NoteImage> mImages;
    private Context mContext;

    public NoteImageAdapter(Context context) {
        mContext = context;
        mImages = new ArrayList<>();
    }

    public void setImages(List<NoteImage> images) {
        mImages = images;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_note_image, parent, false);
        return new ImageViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        NoteImage image = mImages.get(position);
        holder.bind(image);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
        }

        public void bind(NoteImage image) {
            // Set the image to ImageView using an image loading library or other means
            // Example: Glide.with(mContext).load(image.getUrl()).into(mImageView);
        }
    }
}
