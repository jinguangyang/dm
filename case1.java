//1.早期应用调用  
String read(String cmd) {
        Runtime runtime = Runtime.getRuntime();
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        Process proc;
        String result = null;
        try {
            proc = runtime.exec(cmd);
            is = proc.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            result = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
                assert isr != null;
                isr.close();
                assert br != null;
                br.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

 public String  getMAC(){
        String mac =null;
        try{
            mac = read("cat /sys/class/net/eth0/address");
        }catch (Exception e){

        }
        return mac==null?"":mac;
    }


//2.后期应用调用接口

Settings.Global.getString(context.getContentResolver(), "WiFiMac");
