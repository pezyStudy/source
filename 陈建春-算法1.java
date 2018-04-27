package test;

public class test {
	public static void main(String[] args) {
		int [] a= {3,4,1,8,5,4};
		//测试排序方法
		int [] result =mergesort(a,0,a.length-1);
		for(int i :result) {
			System.out.println(i);
		}	
	}	
	
	
	
	//图解冒泡
	public static void maopao(int [] a) {
		//非空判断 空报错  只有一个值不用排序
		int aaa=0;
		for(int i =0;i<a.length-1;i++) {
			boolean flag=true;
			for (int j =0;j<a.length-1-i;j++) {
				aaa++;
				if(a[j]>a[j+1]) {
					//换值优化
					a[j]=a[j]+a[j+1];
					a[j+1]=a[j]-a[j+1];
					a[j]=a[j]-a[j+1];
					
					//游标优化
					flag=false;
				}
			}
			if(flag) {
				System.out.println("*************"+aaa);
				return;
			}
		}		
	}
		

	public static void kuaisu(int[]arr,int low,int high) {
		int l= low;
		int h=high;
		int povit=arr[low];
		 
		while(l<h){
			while(l<h&&arr[h]>=povit) h--;
			if(l<h){
				int temp=arr[h];
				arr[h]=arr[l];
				arr[l]=temp;
				l++;
			}
		 
			while(l<h&&arr[l]<=povit) l++;
			if(l<h){
			int temp=arr[h];
			arr[h]=arr[l];
			arr[l]=temp;
			h--;
			}
		}
		if(l>low)kuaisu(arr,low,l-1);
		if(h<high)kuaisu(arr,l+1,high);
	}

	
	public static int[] mergesort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
        	mergesort(a,low,mid);
        	mergesort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }
     
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组 
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }
 
}
