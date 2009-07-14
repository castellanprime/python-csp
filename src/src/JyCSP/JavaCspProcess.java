package JyCSP;

import org.python.core.*;

/**
 * 
 * @author Sam Wilson, Sarah Mount
 * @version 1.0
 * 
 *  Java representation of the Jython Class JyCspProcess.
 * 
 * 
 * 
 */


public abstract class JavaCspProcess extends PyObject implements JavaCspProcessInterface{
	
	/**
	 * Java Process Interface for the Jython Class JycspProcess.
	 */
	protected JyCspProcessInterface jcpi;
	
	/**
	 * Required for nesting
	 */
	public Object enclosing;
	
	
	/**
	 * Default constructor
	 */
	public JavaCspProcess(){
		super();
		this.jcpi = CspFactory.createJavaCspProcess(this);
	}
	
	/**
	 * Straight through call to the Jython method
	 * 
	 * starts the Process running, this is equivalent to
	 * 
	 * Thread.start();
	 * 
	 * 
	 */
	public void start(){
		this.jcpi.start();
	}
	
	/**
	 * Straight through method call to Jython method
	 * JyCspProcess.run()
	 * 
	 * unknown behaviour (inherited method)
	 */
	public void run(){
		this.jcpi.run();
	}
	
	/**
	 * Stright through method call to Jython method
	 * 
	 * Causes the thread to sleep for a set about of time,
	 * this is equivalent to
	 * 
	 * Thread.sleep(long)
	 * 
	 * @param t Duration to sleep for
	 */
	public void sleep(int t){
		this.jcpi.sleep(t);
	}
	
	/**
	 * Straight through method call
	 * 
	 * Gets a unique name
	 * 
	 * @return the Pid of the Process
	 */
	public long getPid(){
		return this.jcpi.getPid();
	}
	
	public Thread.State getState(){
		return this.jcpi.getState();
	}
	
	public void join(){
		this.jcpi.join();
	}

}