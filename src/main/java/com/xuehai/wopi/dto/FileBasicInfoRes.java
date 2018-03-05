package com.xuehai.wopi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: chenyj
 * @Description:
 * @Date: create in 2018-03-01 11:24
 */
@Getter
@Setter
@Accessors(chain = true)
//@ToString
public class FileBasicInfoRes {

    @JsonProperty(value = "BaseFileName")
    private String baseFileName;
    @JsonProperty(value = "Size")
    private long size;
    @JsonProperty(value = "OwnerId")
    private String ownerId;
    @JsonProperty(value = "Version")
    private String version;
    @JsonProperty(value = "SHA256")
    private String sha256;
    @JsonProperty(value = "AllowExternalMarketplace")
    private boolean allowExternalMarketplace;
    @JsonProperty(value = "UserCanWrite")
    private boolean userCanWrite;
    @JsonProperty(value = "SupportsUpdate")
    private boolean supportsUpdate;

    @JsonProperty(value = "BreadcrumbBrandName")
    private String breadcrumbBrandName;
    @JsonProperty(value = "BreadcrumbBrandUrl")
    private String breadcrumbBrandUrl;
    @JsonProperty(value = "BreadcrumbDocName")
    private String breadcrumbDocName;
    @JsonProperty(value = "BreadcrumbDocUrl")
    private String breadcrumbDocUrl;
    @JsonProperty(value = "BreadcrumbFolderName")
    private String breadcrumbFolderName;
    @JsonProperty(value = "BreadcrumbFolderUrl")
    private String breadcrumbFolderUrl;
    @JsonProperty(value = "ClientUrl")
    private String clientUrl;
    @JsonProperty(value = "CloseButtonClosesWindow")
    private boolean closeButtonClosesWindow = false;
    @JsonProperty(value = "CloseUrl")
    private String closeUrl;
    @JsonProperty(value = "DisableBrowserCachingOfUserContent")
    private boolean disableBrowserCachingOfUserContent = false;
    @JsonProperty(value = "DisablePrint")
    private boolean disablePrint = false;
    @JsonProperty(value = "DisableTranslation")
    private boolean disableTranslation = false;
    @JsonProperty(value = "DownloadUrl")
    private String downloadUrl;
    @JsonProperty(value = "FileSharingUrl")
    private String fileSharingUrl;
    @JsonProperty(value = "FileUrl")
    private String fileUrl;
    @JsonProperty(value = "HostAuthenticationId")
    private String hostAuthenticationId;
    @JsonProperty(value = "HostEditUrl")
    private String hostEditUrl;
    @JsonProperty(value = "HostEmbeddedEditUrl")
    private String hostEmbeddedEditUrl;
    @JsonProperty(value = "HostEmbeddedViewUrl")
    private String hostEmbeddedViewUrl;
    @JsonProperty(value = "HostName")
    private String hostName;
    @JsonProperty(value = "HostNotes")
    private String hostNotes;
    @JsonProperty(value = "HostRestUrl")
    private String hostRestUrl;
    @JsonProperty(value = "HostViewUrl")
    private String hostViewUrl;
    @JsonProperty(value = "IrmPolicyDescription")
    private String irmPolicyDescription;
    @JsonProperty(value = "IrmPolicyTitle")
    private String irmPolicyTitle;
    @JsonProperty(value = "PresenceProvider")
    private String presenceProvider;
    @JsonProperty(value = "PresenceUserId")
    private String presenceUserId;
    @JsonProperty(value = "PrivacyUrl")
    private String privacyUrl;
    @JsonProperty(value = "ProtectInClient")
    private boolean protectInClient = false;
    @JsonProperty(value = "ReadOnly")
    private boolean readOnly = false;
    @JsonProperty(value = "RestrictedWebViewOnly")
    private boolean restrictedWebViewOnly = false;
    @JsonProperty(value = "SignoutUrl")
    private String signoutUrl;
    @JsonProperty(value = "SupportsCoauth")
    private boolean supportsCoauth = false;
    @JsonProperty(value = "SupportsCobalt")
    private boolean supportsCobalt = false;
    @JsonProperty(value = "SupportsFolders")
    private boolean supportsFolders = true;
    @JsonProperty(value = "SupportsLocks")
    private boolean supportsLocks = true;
    @JsonProperty(value = "SupportsScenarioLinks")
    private boolean supportsScenarioLinks = false;
    @JsonProperty(value = "SupportsSecureStore")
    private boolean supportsSecureStore = false;
    @JsonProperty(value = "TenantId")
    private String tenantId;
    @JsonProperty(value = "TermsOfUseUrl")
    private String termsOfUseUrl;
    @JsonProperty(value = "TimeZone")
    private String timeZone;
    @JsonProperty(value = "UserCanAttend")
    private boolean userCanAttend = false;
    @JsonProperty(value = "UserCanNotWriteRelative")
    private boolean userCanNotWriteRelative = false;
    @JsonProperty(value = "UserCanPresent")
    private boolean userCanPresent = false;
    @JsonProperty(value = "UserFriendlyName")
    private String userFriendlyName;
    @JsonProperty(value = "UserId")
    private String userId;
    @JsonProperty(value = "WebEditingDisabled")
    private boolean webEditingDisabled = false;

    @Override
    public String toString() {
        return "FileBasicInfoRes{" +
                "baseFileName='" + baseFileName + '\'' +
                ", size=" + size +
                ", ownerId='" + ownerId + '\'' +
                ", version='" + version + '\'' +
                ", sha256='" + sha256 + '\'' +
                ", allowExternalMarketplace=" + allowExternalMarketplace +
                ", userCanWrite=" + userCanWrite +
                ", supportsUpdate=" + supportsUpdate +
                ", breadcrumbBrandName='" + breadcrumbBrandName + '\'' +
                ", breadcrumbBrandUrl='" + breadcrumbBrandUrl + '\'' +
                ", breadcrumbDocName='" + breadcrumbDocName + '\'' +
                ", breadcrumbDocUrl='" + breadcrumbDocUrl + '\'' +
                ", breadcrumbFolderName='" + breadcrumbFolderName + '\'' +
                ", breadcrumbFolderUrl='" + breadcrumbFolderUrl + '\'' +
                ", clientUrl='" + clientUrl + '\'' +
                ", closeButtonClosesWindow=" + closeButtonClosesWindow +
                ", closeUrl='" + closeUrl + '\'' +
                ", disableBrowserCachingOfUserContent=" + disableBrowserCachingOfUserContent +
                ", disablePrint=" + disablePrint +
                ", disableTranslation=" + disableTranslation +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", fileSharingUrl='" + fileSharingUrl + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", hostAuthenticationId='" + hostAuthenticationId + '\'' +
                ", hostEditUrl='" + hostEditUrl + '\'' +
                ", hostEmbeddedEditUrl='" + hostEmbeddedEditUrl + '\'' +
                ", hostEmbeddedViewUrl='" + hostEmbeddedViewUrl + '\'' +
                ", hostName='" + hostName + '\'' +
                ", hostNotes='" + hostNotes + '\'' +
                ", hostRestUrl='" + hostRestUrl + '\'' +
                ", hostViewUrl='" + hostViewUrl + '\'' +
                ", irmPolicyDescription='" + irmPolicyDescription + '\'' +
                ", irmPolicyTitle='" + irmPolicyTitle + '\'' +
                ", presenceProvider='" + presenceProvider + '\'' +
                ", presenceUserId='" + presenceUserId + '\'' +
                ", privacyUrl='" + privacyUrl + '\'' +
                ", protectInClient=" + protectInClient +
                ", readOnly=" + readOnly +
                ", restrictedWebViewOnly=" + restrictedWebViewOnly +
                ", signoutUrl='" + signoutUrl + '\'' +
                ", supportsCoauth=" + supportsCoauth +
                ", supportsCobalt=" + supportsCobalt +
                ", supportsFolders=" + supportsFolders +
                ", supportsLocks=" + supportsLocks +
                ", supportsScenarioLinks=" + supportsScenarioLinks +
                ", supportsSecureStore=" + supportsSecureStore +
                ", tenantId='" + tenantId + '\'' +
                ", termsOfUseUrl='" + termsOfUseUrl + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", userCanAttend=" + userCanAttend +
                ", userCanNotWriteRelative=" + userCanNotWriteRelative +
                ", userCanPresent=" + userCanPresent +
                ", userFriendlyName='" + userFriendlyName + '\'' +
                ", userId='" + userId + '\'' +
                ", webEditingDisabled=" + webEditingDisabled +
                '}';
    }
}
