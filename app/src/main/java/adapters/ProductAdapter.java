package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ishoppinglist.R;

import java.util.List;

import models.Producto;

public class ProductAdapter extends ArrayAdapter<Producto> {

    private List<Producto> products;

    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Producto> list) {
        super(context, resource, list);
        this.products = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Producto p = this.products.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product, parent, false);
        }
        TextView tvProduct = convertView.findViewById(R.id.tvProductList);

        tvProduct.setText(p.getName());

        return convertView;

    }

    @Override
    public View getDropDownView(int position, View convertview, @NonNull ViewGroup parent) {
        Producto p = products.get(position);
        if (convertview == null) {
            convertview = LayoutInflater.from(getContext()).inflate(R.layout.product_spinner, parent, false);
            TextView tvSpinnerItem = convertview.findViewById(R.id.tvSpinnerItem);
            tvSpinnerItem.setText(p.getName());
        }
        return convertview;
    }

}
