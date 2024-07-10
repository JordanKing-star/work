package com.strontech.imgautam.patanjalistorenew.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.model.Product;
import com.strontech.imgautam.patanjalistorenew.userfragments.UserProductDescFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by imgautam on 6/3/18.
 */

public class ProductsRecyclerAdapter extends
    RecyclerView.Adapter<ProductsRecyclerAdapter.ProductViewHolder> {

  private List<Product> productList;

  Context context;

  //make constructor
  public ProductsRecyclerAdapter(List<Product> productList, Context context) {
    this.context = context;
    this.productList = productList;
  }

  @Override
  public ProductViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {

    //inflate the recycler item view

    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_product_recycler, parent, false);

    return new ProductViewHolder(itemView, productList, context);
  }

  @Override
  public void onBindViewHolder(ProductViewHolder holder, int position) {

    //set the products
    //holder.imageViewProductImage.setImageBitmap(productList.get(position).getProduct_image());

    byte[] product_image = productList.get(position).getProduct_image();
    Bitmap bitmap = BitmapFactory.decodeByteArray(product_image, 0, product_image.length);

    holder.imageViewProductImage.setImageBitmap(bitmap);
    holder.textViewProductName.setText(productList.get(position).getProduct_name());
    holder.textViewProductQuantity.setText(productList.get(position).getProduct_qauntity());
    holder.textViewProductPrice.setText("Rs. " + productList.get(position).getProduct_price());
    holder.textViewProductDesc.setText(productList.get(position).getProduct_desc());

  }

  @Override
  public int getItemCount() {

    Log.v(ProductsRecyclerAdapter.class.getSimpleName(), "" + productList.size());
    return productList.size();
  }


  /**
   * ViewHolder class
   */
  class ProductViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageViewProductImage;

    public TextView textViewProductName;
    public TextView textViewProductQuantity;
    public TextView textViewProductPrice;
    public TextView textViewProductDesc;

    List<Product> productList = new ArrayList<Product>();

    public ProductViewHolder(View itemView, List<Product> productList, Context context) {

      super(itemView);

      imageViewProductImage = itemView.findViewById(R.id.imageViewProductImage);
      textViewProductName = itemView.findViewById(R.id.textViewProductName);
      textViewProductQuantity = itemView.findViewById(R.id.textViewProductQuantity);
      textViewProductPrice = itemView.findViewById(R.id.textViewProductPrice);
      textViewProductDesc = itemView.findViewById(R.id.textViewProductDesc);
    }

  }
}
