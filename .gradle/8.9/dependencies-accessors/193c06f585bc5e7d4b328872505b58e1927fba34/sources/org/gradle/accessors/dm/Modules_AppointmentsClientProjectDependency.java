package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.ProjectDependency;
import org.gradle.api.internal.artifacts.dependencies.ProjectDependencyInternal;
import org.gradle.api.internal.artifacts.DefaultProjectDependencyFactory;
import org.gradle.api.internal.artifacts.dsl.dependencies.ProjectFinder;
import org.gradle.api.internal.catalog.DelegatingProjectDependency;
import org.gradle.api.internal.catalog.TypeSafeProjectDependencyFactory;
import javax.inject.Inject;

@NonNullApi
public class Modules_AppointmentsClientProjectDependency extends DelegatingProjectDependency {

    @Inject
    public Modules_AppointmentsClientProjectDependency(TypeSafeProjectDependencyFactory factory, ProjectDependencyInternal delegate) {
        super(factory, delegate);
    }

    /**
     * Creates a project dependency on the project at path ":modules:appointments_client:api"
     */
    public Modules_AppointmentsClient_ApiProjectDependency getApi() { return new Modules_AppointmentsClient_ApiProjectDependency(getFactory(), create(":modules:appointments_client:api")); }

    /**
     * Creates a project dependency on the project at path ":modules:appointments_client:impl"
     */
    public Modules_AppointmentsClient_ImplProjectDependency getImpl() { return new Modules_AppointmentsClient_ImplProjectDependency(getFactory(), create(":modules:appointments_client:impl")); }

}
