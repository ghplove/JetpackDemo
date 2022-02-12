
#### Observable Objects
目前所提供的ObservableField有：

|Observable类型	|对应原类型|
|:----- |:------ |
|ObservableArrayList|	ArrayList|
|ObservableArrayMap|	ArrayMap|
|ObservableBoolean|	boolean|
|ObservableByte|	byte|
|ObservableChar|	char|
|ObservableFloat|	float|
|ObservableDouble|	double|
|ObservableLong|	long|
|ObservableInt|	int|
|ObservableParcelable<T extends Parcelable>|	<T extends Parcelable>|
|ObservableField<T>|	<T>|

#### 表达式
支持的运算符：
<ul>
<li>数学运算符： + - / * %</li>
<li>字符串拼接： +</li>
<li>逻辑运算符： && ||</li>
<li>二进制： & | ^</li>
<li>一元运算符： +</li>
<li>位运算符： >> >>> <<</li>
<li>比较： == > < >= <=</li>
<li>instanceof</li>
<li>()</li>
<li>数据类型： character, String, numeric, null</li>
<li>类型转换（ClassCast）</li>
<li>方法回调（Method calls）</li>
<li>数据属性</li>
<li>数组：[]</li>
<li>三元操作符：？</li>
</ul>

#### 常用注解
@Bindable
@BindingAdapter
@BindingConversion
@BindingMethod
@BindingMethods
@InverseBindingAdapter
@InverseBindingMethod
@InverseBindingMethods
@InverseMethod
@Untaggable
@BindingBuildInfo

