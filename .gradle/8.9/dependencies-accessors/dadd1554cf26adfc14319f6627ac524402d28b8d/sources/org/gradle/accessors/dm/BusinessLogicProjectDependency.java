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
public class BusinessLogicProjectDependency extends DelegatingProjectDependency {

    @Inject
    public BusinessLogicProjectDependency(TypeSafeProjectDependencyFactory factory, ProjectDependencyInternal delegate) {
        super(factory, delegate);
    }

    /**
     * Creates a project dependency on the project at path ":business_logic:appointments_api"
     */
    public BusinessLogic_AppointmentsApiProjectDependency getAppointmentsApi() { return new BusinessLogic_AppointmentsApiProjectDependency(getFactory(), create(":business_logic:appointments_api")); }

    /**
     * Creates a project dependency on the project at path ":business_logic:appointments_client"
     */
    public BusinessLogic_AppointmentsClientProjectDependency getAppointmentsClient() { return new BusinessLogic_AppointmentsClientProjectDependency(getFactory(), create(":business_logic:appointments_client")); }

}
