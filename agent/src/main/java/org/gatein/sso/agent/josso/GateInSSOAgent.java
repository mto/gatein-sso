/*
* JBoss, a division of Red Hat
* Copyright 2006, Red Hat Middleware, LLC, and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.gatein.sso.agent.josso;

import org.gatein.common.logging.Logger;
import org.gatein.common.logging.LoggerFactory;
import org.josso.agent.SSOAgentRequest;
import org.josso.agent.http.HttpSSOAgent;
import org.josso.gateway.identity.service.SSOIdentityManagerService;

import java.lang.reflect.Method;
import java.security.Principal;

/**
 *
 * @org.apache.xbean.XBean element="agent"
 *
 * @author <a href="mailto:sshah@redhat.com">Sohil Shah</a>
 */
public class GateInSSOAgent extends HttpSSOAgent
{

    private static final Logger log = LoggerFactory.getLogger(GateInSSOAgent.class);

    protected Principal authenticate(SSOAgentRequest request) 
    {
       GateInAuthenticationDelegate authDelegate = GateInJOSSOAgentFactory.getInstance().getAuthenticationDelegate();
       return authDelegate.authenticate(this.getSSOIdentityManager(), request);
    }

    protected boolean isAuthenticationAlwaysRequired() 
    {
        return true;
    }

    protected void log(String message) 
    {
        log.debug(message);
    }

    protected void log(String message, Throwable throwable) 
    {
        log.debug(message, throwable);
    }
}
