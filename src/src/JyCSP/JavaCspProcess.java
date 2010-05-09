package JyCSP;

import org.python.core.*;

import JyCSP.Interfaces.JavaCspProcessInterface;
import JyCSP.Interfaces.JyCspProcessInterface;
import JyCSP.util.CspFactory;

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
	public Object enclosing = new Object();
	
	
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
	
	public void join(long d){
		this.jcpi.join(d);
	}

}
