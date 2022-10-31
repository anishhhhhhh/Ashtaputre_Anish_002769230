package neu.data.constants;

public class AccessLevels {
    private static final String DOCTOR_ACCESS = "doctor";
    private static final String PATIENT_ACCESS = "patient";
    private static final String HOSPITAL_ADMIN_ACCESS = "hos_adm";
    private static final String CMMUNITY_ADMIN_ACCESS = "com_adm";
    private static final String SYSTEM_ADMIN_ACCESS = "sys_adm";

    public static String getDoctorAccess() {
        return DOCTOR_ACCESS;
    }

    public static String getPatientAccess() {
        return PATIENT_ACCESS;
    }

    public static String getHospitalAdminAccess() {
        return HOSPITAL_ADMIN_ACCESS;
    }

    public static String getCommunityAdminAccess() {
        return CMMUNITY_ADMIN_ACCESS;
    }

    public static String getSystemAdminAccess() {
        return SYSTEM_ADMIN_ACCESS;
    }
}
