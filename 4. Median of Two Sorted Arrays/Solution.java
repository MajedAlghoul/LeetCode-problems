class Solution {
    public static boolean isEven(int input){
        if(input%2==0)
            return true;
        else
            return false;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        LinkList nums1List=new LinkList();
        LinkList nums2List=new LinkList();
        for(int i=0;i<nums1.length;i++){
            nums1List.addlast(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            nums2List.addlast(nums2[i]);
        }
        LinkList result=nums1List.marge(nums2List);
        if(isEven(result.count)){
            Link mid1=result.first,mid2;
            for(int k=0;k<(result.count/2)-1;k++){
                mid1=mid1.next;
            }
            mid2=mid1.next;
            return ((mid1.data+mid2.data)/2.0);
        }
        else{
            Link mid=result.first;
            for(int k=0;k<(((result.count+1)/2)-1);k++){
                mid=mid.next;
            }
            return mid.data;
        }
    }
}
class LinkList {
    public Link first, last;
    public int count;

    public void addfirst(int data) {
        if (count == 0) {
            first = new Link(data);
            last = first;
        } else {
            Link newLink = new Link(data);
            newLink.next = first;
            first = newLink;
        }
        count++;
    }

    public void addlast(int data) {
        if (count == 0) {
            first = new Link(data);
            last = first;
        } else {
            last.next = new Link(data);
            last = last.next;
        }
        count++;
    }

    public LinkList marge(LinkList l2) {
        LinkList result = new LinkList();
        Link p1 = first, p2 = l2.first;
        if (p1 != null && (p2 == null || p1.data < p2.data)) {
            result.first = new Link(p1.data);
            result.last = result.first;
            p1 = p1.next;
        } else {
            result.first = new Link(p2.data);
            result.last = result.first;
            p2 = p2.next;
        }
        result.count = count + l2.count;
        for (int i = 0; i < result.count - 1; i++) {
            if (p1 == null) {
                result.last.next = p2;
                result.last = l2.last;
                return result;
            } else if (p2 == null) {
                result.last.next = p1;
                result.last = last;
                return result;
            } else if (p1.data < p2.data) {
                result.last.next = new Link(p1.data);
                p1 = p1.next;
            } else {
                result.last.next = new Link(p2.data);
                p2 = p2.next;
            }
            result.last = result.last.next;
        }
        return result;
    }
}
class Link {
    public int data;
    public Link next;
    public Link(int data){
        this.data=data;
    }
}