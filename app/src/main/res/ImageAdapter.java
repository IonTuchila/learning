import android.content.Context;
import android.widget.BaseAdapter;

/**
 * Created by E7450 on 1/18/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return ThumbIds.lenght;
    }
    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    private Integer[] mThumbIds = {
            R.drawable.download1, R.drawable.download2,
            R.drawable.download3, R.drawable.download4,
            R.drawable.download5, R.drawable.download6,
            R.drawable.download7, R.drawable.download8,
            R.drawable.download9, R.drawable.download10


    };
}
