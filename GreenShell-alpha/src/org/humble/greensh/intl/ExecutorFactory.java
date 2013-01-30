/**
 * 
 */
package org.humble.greensh.intl;

import java.util.List;

/**
 * @author cshou
 *
 */
public abstract class ExecutorFactory {
	
	protected List<Executor> execList = null;
	
	public abstract List<Executor> getExecList();

}
