

auto_adapter-master
this is a android recyclerView wheel
============================================================================


frist  plugins
============================================================================
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
    dependencies {
	        'com.github.houruixiang-itcenter:auto_adapter-master:v1.0.1'
	}
  
  sure  suggest to  as 
  
let's  try to it
============================================================================
  
  ##create your  adapter:
 
  
      public class MyAdapter extends BaseAutoAdapter<String> {


        public MyAdapter(Context context) {
            super(context);
        }
      }
 ##create your  Delegate:

 
    public class SimpleItemDelegate implements IitemDelegate<String> {


    private int resId;
    private Context context;

    public SimpleItemDelegate(Context context, int resId) {
        this.context = context;
        this.resId = resId;
    }

    @Override
    public boolean isViewType(String itemBean) {
        if (itemBean instanceof String){
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewType(String itemBean, int position) {
        if (itemBean instanceof String){
            return true;
        }
        return false;
    }

    @Override
    public int getItemLayoutId() {
        return resId;
    }


    @Override
    public void convert(AutoViewHolder holder, String itemBean, int position) {
        holder.setText(R.id.txt, (String) itemBean);
    }
}


##last to use it:


         MyAdapter adapter = new MyAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        

        adapter.setData(info);
        adapter.addDelegate(new SimpleItemDelegate(this,R.layout.item_main));
        adapter.notifyDataSetChanged();
      
      
