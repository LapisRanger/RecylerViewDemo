# RecylerViewDemo
MAD练习3,模拟抖音消息界面,点击每个Item跳转到新的界面并显示Item的编号

## RecyclerView简单使用步骤:

1. 在app/build.gradel的dependencies闭包中添加RecyclerView依赖,或在xml文件中找到RecyclerView并点击右侧的下载

2. 在res/layout/activity_main.xml中加入RecyclerView控件

3. 新建Item.java类,里面包含所有Item的属性,如String类型的字符串信息(TextView),int类型的ImageID(对应ImageView)等.使用alt+Insert可以快速构建
Item类的constructor和这些属性的getter

4. 创建Item.xml作为列表项的视图,类似ListView

5. 创建Item的适配器,并让其继承于RecyclerView.Adapter,把泛型指定为ItemAdapter.ViewHolder.

参考[简书RecyclerView](https://www.jianshu.com/p/b4bb52cdbeb7)

```java
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private  List<Fruit> mFruitList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder (View view)
        {
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruitname);
        }

    }

    public  FruitAdapter (List <Fruit> fruitList){
        mFruitList = fruitList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount(){
        return mFruitList.size();
    }
```
   FruitAdapter构造函数,用于把要展示的数据源传入,并赋予值给全局变量mFruitList。

   FruitAdapter继承RecyclerView.Adapter。因此必须重写onCreateViewHolder(),onBindViewHolder()和getItemCount()三个方法

   onCreateViewHolder()用于创建ViewHolder实例,并把加载的布局传入到构造函数去,再把ViewHolder实例返回。

   onBindViewHolder()则是用于对子项的数据进行赋值,会在每个子项被滚动到屏幕内时执行。position得到当前项的Fruit实例。

   getItemCount()返回RecyclerView的子项数目。

6. 修改MainActivity.java,构建ArrayList数组存放Item的数据源,为RecyclerList设置LayoutManager(可设置横向或竖向线性,表格和瀑布流)和数据适配器Adapter


## 圆形头像:

使用第三方控件RoundedImageView.

1. 添加依赖(repositories和dependencies)

2. 在xml文件中加入,可采用与ImageView类似的方法在java代码中设置图片,xml属性为app:src=""

3. 设置圆形属性 oval="true"


## 适配器构造器传参context实现点击跳转:

   因为需要实现Activity之间的数据传递和界面跳转,所以直接在适配器创建的时候传入MainActivity的context,也即修改Adapter的constructor并添加context属性

   修改ItemAdapter.java,为holder.itemView添加一个点击事件监听器

   直接File->New->Activity,并在Manifest.xml中添加向上导航(parentActivityName="")

   使用Intent+Bundle传参.对应函数是putExtra()和getBundleExtra()

