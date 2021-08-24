package mypackage;

import java.util.*;
import java.io.*;
import intradoc.common.*;
import intradoc.data.*;
import intradoc.server.*;
import intradoc.shared.*;



public class myCheckinClass extends ServiceHandler
{

    /**
     *Sterin Jacob
     * Demo to use CHECKIN_UNIVERSAL From ServiceHandler
     */



    public void myCheckinmethod() throws DataException, ServiceException

    {


                    traceVerbose("before");
                    intradoc.data.DataBinder mydataBinder = m_binder;
                    mydataBinder.putLocal("IdcService", "CHECKIN_UNIVERSAL");
                    mydataBinder.putLocal("primaryFile","nn.txt");
                    mydataBinder.putLocal("primaryFile:path","/tmp/nn.txt");
                    mydataBinder.putLocal("dDocAuthor","weblogic");
                    mydataBinder.putLocal("dDocTitle","My Title");
                    mydataBinder.putLocal("dDocAccount","");
                    mydataBinder.putLocal("dDocType","Document");
                    mydataBinder.putLocal("dSecurityGroup","Public");
                    mydataBinder.addTempFile("/tmp/nn.txt");
                    this.executeService(mydataBinder,"CHECKIN_UNIVERSAL");


} // end of myRIDCmethod


private void executeService(final intradoc.data.DataBinder serviceBinder, final String serviceName) throws ServiceException

                  {


                       traceVerbose("Start executeService");


                           try {
                                traceVerbose("Calling service " + serviceName + ": " + serviceBinder.getLocalData().toString());
                                // Execute service
                                m_service.getRequestImplementor().executeServiceTopLevelSimple(serviceBinder, serviceName, m_service.getUserData());
                               traceVerbose("Finished calling service");

                               } catch (final DataException e) {
                                     traceVerbose("Something went wrong executing service " + serviceName);
                                       e.printStackTrace(System.out);
                                   throw new ServiceException("Something went wrong executing service " + serviceName, e);
                               } finally {
                                         traceVerbose("End executeService");
                               }
                }

private static void trace(final String message)

              {          // Setting trace section
                           Report.trace("myDummy", message, null);
              }


 private static void traceVerbose(final String message)

                  {

                if (Report.m_verbose)
                         {
                        trace(message);
                         }
                   }



}// end of class
