package test;

public class test {
	public static void main(String[] args) {
		int [] a= {3,4,1,8,5,4};
		//�������򷽷�
		int [] result =mergesort(a,0,a.length-1);
		for(int i :result) {
			System.out.println(i);
		}	
	}	
	
	
	
	//ͼ��ð��
	public static void maopao(int [] a) {
		//�ǿ��ж� �ձ���  ֻ��һ��ֵ��������
		int aaa=0;
		for(int i =0;i<a.length-1;i++) {
			boolean flag=true;
			for (int j =0;j<a.length-1-i;j++) {
				aaa++;
				if(a[j]>a[j+1]) {
					//��ֵ�Ż�
					a[j]=a[j]+a[j+1];
					a[j+1]=a[j]-a[j+1];
					a[j]=a[j]-a[j+1];
					
					//�α��Ż�
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
            //���ҹ鲢
            merge(a,low,mid,high);
        }
        return a;
    }
     
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // �ѽ�С�������Ƶ���������
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // �����ʣ������������� 
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // ���ұ߱�ʣ�������������
        while(j<=high){
            temp[k++] = a[j++];
        }
        // ���������е�������nums����
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }
 
}
