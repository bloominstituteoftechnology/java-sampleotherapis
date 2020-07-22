# Java Sample Employee Initial Version

## Introduction

This project is used to introduce Java Spring REST API CRUD applications. As such it is a small application showing just the code that is needed to explain the topic.

## Database layout

The table layouts are as follows:

- Employee is the driving table
- Email has a Many-To-One relationship with Employee. Each employee has many emails. Each email has only one employee.
- Jobtitles has a Many-To-Many relationship with Employee
- EmployeeTitles the join table between Jobtitles and Employee

![Image of Database Layout](sampleemps-audit-db.png)

Using the provided seed data, the given endpoint will produce the stated output. Expand each endpoint to see it's correct output. Note I am only generated 3 random Java Faker Employees

<details>
<summary>http://localhost:2019/employees/employees</summary>

```JSON
[
    {
        "employeeid": 3,
        "name": "CINNAMON",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            },
            {
                "jobname": {
                    "jobtitleid": 2,
                    "title": "Wizard"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 4,
                "email": "hops@local.com"
            },
            {
                "emailid": 5,
                "email": "bunny@hoppin.local"
            }
        ]
    },
    {
        "employeeid": 6,
        "name": "BARNBARN",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 7,
                "email": "barnbarn@local.com"
            }
        ]
    },
    {
        "employeeid": 8,
        "name": "JOHN",
        "salary": 75000.0,
        "jobnames": [],
        "emails": []
    },
    {
        "employeeid": 9,
        "name": "Noel Huels III",
        "salary": 113698.15297821208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 10,
                "email": "mariam.okeefe@gmail.com"
            },
            {
                "emailid": 11,
                "email": "porter.howe@yahoo.com"
            },
            {
                "emailid": 12,
                "email": "georgianne.kemmer@gmail.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/employees/employee/3</summary>

```JSON{
    "employeeid": 3,
    "name": "CINNAMON",
    "salary": 80000.0,
    "jobnames": [
        {
            "jobname": {
                "jobtitleid": 1,
                "title": "Big Boss"
            },
            "manager": "Stumps"
        },
        {
            "jobname": {
                "jobtitleid": 2,
                "title": "Wizard"
            },
            "manager": "Stumps"
        }
    ],
    "emails": [
        {
            "emailid": 4,
            "email": "hops@local.com"
        },
        {
            "emailid": 5,
            "email": "bunny@hoppin.local"
        }
    ]
}
```

</details>

<details>
<summary>http://localhost:2019/employees/employee/777</summary>

```JSON
{
    "timestamp": "2020-07-21 15:22:04",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Employee 777 Not Found",
    "trace": "javax.persistence.EntityNotFoundException: Employee 777 Not Found\n\tat com.lambdaschool.sampleemps.services.EmployeeServiceImpl.lambda$findEmployeeById$0(EmployeeServiceImpl.java:46)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:401)\n\tat com.lambdaschool.sampleemps.services.EmployeeServiceImpl.findEmployeeById(EmployeeServiceImpl.java:46)\n\tat com.lambdaschool.sampleemps.services.EmployeeServiceImpl$$FastClassBySpringCGLIB$$4105708a.invoke(<generated>)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:687)\n\tat com.lambdaschool.sampleemps.services.EmployeeServiceImpl$$EnhancerBySpringCGLIB$$318cfc26.findEmployeeById(<generated>)\n\tat com.lambdaschool.sampleemps.controllers.EmployeeController.getEmployeeById(EmployeeController.java:45)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:105)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:634)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:373)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1130)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:630)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n\tat java.base/java.lang.Thread.run(Thread.java:832)\n",
    "path": "/employees/employee/777"
}
```

</details>

<details>
<summary>http://localhost:2019/employees/employeename/mon</summary>

```JSON
[
    {
        "employeeid": 3,
        "name": "CINNAMON",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            },
            {
                "jobname": {
                    "jobtitleid": 2,
                    "title": "Wizard"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 4,
                "email": "hops@local.com"
            },
            {
                "emailid": 5,
                "email": "bunny@hoppin.local"
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/employees/employeeemail/com</summary>

```JSON
[
    {
        "employeeid": 3,
        "name": "CINNAMON",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            },
            {
                "jobname": {
                    "jobtitleid": 2,
                    "title": "Wizard"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 4,
                "email": "hops@local.com"
            },
            {
                "emailid": 5,
                "email": "bunny@hoppin.local"
            }
        ]
    },
    {
        "employeeid": 6,
        "name": "BARNBARN",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 7,
                "email": "barnbarn@local.com"
            }
        ]
    },
    {
        "employeeid": 9,
        "name": "Noel Huels III",
        "salary": 113698.15297821208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 10,
                "email": "mariam.okeefe@gmail.com"
            },
            {
                "emailid": 11,
                "email": "porter.howe@yahoo.com"
            },
            {
                "emailid": 12,
                "email": "georgianne.kemmer@gmail.com"
            }
        ]
    },
    {
        "employeeid": 9,
        "name": "Noel Huels III",
        "salary": 113698.15297821208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 10,
                "email": "mariam.okeefe@gmail.com"
            },
            {
                "emailid": 11,
                "email": "porter.howe@yahoo.com"
            },
            {
                "emailid": 12,
                "email": "georgianne.kemmer@gmail.com"
            }
        ]
    },
    {
        "employeeid": 9,
        "name": "Noel Huels III",
        "salary": 113698.15297821208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 10,
                "email": "mariam.okeefe@gmail.com"
            },
            {
                "emailid": 11,
                "email": "porter.howe@yahoo.com"
            },
            {
                "emailid": 12,
                "email": "georgianne.kemmer@gmail.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    }
]
```

</details>

<details>
<summary>POST http://localhost:2019/employees/employee</summary>

DATA

```JSON
{
    "name": "Mojo",
    "salary": 100000.00,
    "jobnames": [
        {
            "jobname":{
                "jobtitleid": 2,
                "title": "Wizard"
            },
            "manager":"stumps"
        }
    ],
    "emails": [
        {
            "email": "mojo@local.com"
        },
        {
            "email": "corgi@home.local"
        }
    ]
}
```

OUTPUT

```TEXT
Location Header: http://localhost:2019/employees/employee/22
STATUS 201 Created
```

</details>

<details>
<summary>PUT http://localhost:2019/employees/employee/13</summary>

DATA

```JSON
{
    "name": "Corgie",
    "salary": 80000.00,
    "jobnames": [
        {
            "jobname":{
                "jobtitleid": 2,
                "title": "Wizard"
            },
            "manager":"stumps"
        },
        {
            "jobname":{
                "jobtitleid": 1,
                "title": "Big Boss"
            },
            "manager":"stumps"
        }
    ],
    "emails": [
        {
            "email": "hops@local.com"
        },
        {
            "email": "bunny@hoppin.local"
        }
    ]
}

```

OUTPUT

```TEXT
STATUS 200 OK
```

</details>

<details>
<summary>PATCH http://localhost:2019/employees/employee/16</summary>

DATA

```JSON
{
    "salary": 100000.00
}
```

OUTPUT

```TEXT
STATUS 200 OK
```

</details>

<details>
<summary>DELETE http://localhost:2019/employees/employee/16</summary>

OUTPUT

```TEXT
STATUS 200 OK
```

</details>

[Sample Swagger Documentation](https://drive.google.com/file/d/1EijscrIhpv6lbnSbLXcaH7NeLFCEpI2l/view)