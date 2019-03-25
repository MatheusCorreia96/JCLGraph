
public class Consumer<S> extends Thread{
	
	private Resource<S> re;
	static Vertice  ret;
	static Edge obj = new Edge(0, 0, "0","0", "0");
	static boolean f = true;
	
	public Consumer(Resource<S> re){
		this.re = re;
	}
	
	public void run(){
		try {
				S str = null;
				
				while((re.isFinished()==false)||(re.getNumOfRegisters()!=0)){		// enquanto a thread do recurso não tiver terminado ou ter mais de zero elementos adiconados a linked list
					if ((str = re.getRegister())!=null){
						synchronized(re){
//							/System.out.println("run"+Thread.currentThread().getName());
							ret = (Vertice) str;								
							obj.wakeup();
							re.suspend();
						}
					}
				}									
			} catch (Exception e) {			
				e.printStackTrace();
			}
				
	}

	public Vertice next() throws Exception{
//		while(ret.name.equals("name")){
//			f=false;
//			synchronized(re){
//				re.wakeup();
//			}
//		}	

	//	System.out.println("next"+Thread.currentThread().getName());
		//	if(f){			
				synchronized(re){
					re.wakeup();
				}
		//	}
			
			synchronized(obj){
			try {
				obj.suspend();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		//	f=true;
			return ret;
	}
}
