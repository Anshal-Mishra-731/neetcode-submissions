class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //some syntax changed
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int tot = nums1.length + nums2.length;
        int half = tot / 2;
        int low = 0;
        int high = nums1.length;
        while(low <= high){
            int mid = (low + high)/2;
            int recht = half - mid;
            if(
            ((mid - 1 >= 0) ? nums1[mid - 1] : Integer.MIN_VALUE) 
            <= 
            ((recht < nums2.length) ? nums2[recht]: Integer.MAX_VALUE)
            &&
            ((recht - 1 >= 0) ? nums2[recht - 1] : Integer.MIN_VALUE)
            <=
            ((mid < nums1.length) ? nums1[mid] : Integer.MAX_VALUE)
            ){
                if(tot % 2 != 0){
                    return (double)Math.min(
                        ((mid < nums1.length) ? nums1[mid] : Integer.MAX_VALUE),
                        ((recht < nums2.length) ? nums2[recht] : Integer.MAX_VALUE)
                    );
                }
                else{
                    return (
                        Math.max(
                            ((mid - 1 >= 0) ? nums1[mid - 1] : Integer.MIN_VALUE),
                            ((recht - 1 >= 0) ? nums2[recht - 1] : Integer.MIN_VALUE)
                        )
                        +
                        Math.min(
                            ((mid < nums1.length) ? nums1[mid] : Integer.MAX_VALUE),
                            ((recht < nums2.length) ? nums2[recht] : Integer.MAX_VALUE)
                        )
                    ) / 2.0;
                }
            }
            else if(
            ((mid - 1 >= 0) ? nums1[mid - 1] : Integer.MIN_VALUE)
            >
            ((recht < nums2.length) ? nums2[recht] : Integer.MAX_VALUE)
            )
            {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return 0.0;
    }
}