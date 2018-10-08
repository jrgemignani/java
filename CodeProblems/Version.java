class Version {
   public static int compareVersion(String version1, String version2) {
      String[] v1Array = version1.split("[.]");
      String[] v2Array = version2.split("[.]");
      int v1Len = v1Array.length;
      int v2Len = v2Array.length;
      int i = 0;
      int j = 0;
      int status = 0;
      while(i < v1Len && j < v2Len){
         int v1 = Integer.parseInt(v1Array[i]);
         int v2 = Integer.parseInt(v2Array[j]);
         if (v1 < v2 && status == 0) status = -1;
         if (v1 > v2 && status == 0) status = 1;
         i++;
         j++;
      }
      if (status == 0){
         while(i < v1Len && Integer.parseInt(v1Array[i]) == 0) i++;
         while(j < v2Len && Integer.parseInt(v2Array[j]) == 0) j++;
         if (i < v1Len) status = 1;
         if (j < v2Len) status = -1;
      }
      return status;
    }

   public static void main(String[] args){
      System.out.println(compareVersion("0.1", "1.1"));
   }
}
