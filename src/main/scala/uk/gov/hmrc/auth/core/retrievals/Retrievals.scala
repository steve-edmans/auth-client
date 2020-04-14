/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.auth.core.retrievals

import java.time.LocalDate

import play.api.libs.json._
import uk.gov.hmrc.auth.core.models._
import uk.gov.hmrc.auth.core.models.legacyCredentials.LegacyCredentials


@deprecated("Please use uk.gov.hmrc.auth.core.retrieve.v2.Retrievals instead", "2.11.0-play-25, 2.11.0-play-26")
trait Retrievals {

  val localDateFormat: Format[LocalDate] = implicitly[Format[LocalDate]]

  val internalId: Retrieval[Option[String]] = OptionalRetrieval("internalId", Reads.StringReads)
  val externalId: Retrieval[Option[String]] = OptionalRetrieval("externalId", Reads.StringReads)
  val credentialStrength: Retrieval[Option[String]] = OptionalRetrieval("credentialStrength", Reads.StringReads)
  val agentCode: Retrieval[Option[String]] = OptionalRetrieval("agentCode", Reads.StringReads)
  @deprecated("Use retrievals that fetch user details data directly as opposed to retrieve json using the uri")
  val userDetailsUri: Retrieval[Option[String]] = OptionalRetrieval("userDetailsUri", Reads.StringReads)
  val affinityGroup: Retrieval[Option[AffinityGroup]] = OptionalRetrieval("affinityGroup", AffinityGroup.format)
  val loginTimes: Retrieval[LoginTimes] = SimpleRetrieval("loginTimes", LoginTimes.format)
  val allEnrolments: Retrieval[Enrolments] = SimpleRetrieval("allEnrolments", Reads.set[Enrolment].map(Enrolments.apply))
  val authorisedEnrolments: Retrieval[Enrolments] = SimpleRetrieval("authorisedEnrolments", Reads.set[Enrolment].map(Enrolments.apply))
  @deprecated("Use 'credentials' retrieval")
  val authProviderId: Retrieval[LegacyCredentials] = SimpleRetrieval("authProviderId", LegacyCredentials.format)
  val mdtpInformation: Retrieval[Option[MdtpInformation]] = OptionalRetrieval("mdtpInformation", MdtpInformation.format)
  val gatewayInformation: Retrieval[Option[GatewayInformation]] = OptionalRetrieval("gatewayInformation", GatewayInformation.format)
  val unreadMessageCount: Retrieval[Option[Int]] = OptionalRetrieval("unreadMessageCount", Reads.IntReads)
  val confidenceLevel: Retrieval[ConfidenceLevel] = SimpleRetrieval("confidenceLevel", Reads.IntReads.map(ConfidenceLevel.apply))
  val nino: Retrieval[Option[String]] = OptionalRetrieval("nino", Reads.StringReads)
  val saUtr: Retrieval[Option[String]] = OptionalRetrieval("saUtr", Reads.StringReads)

  val credentials: Retrieval[Credentials] = SimpleRetrieval("credentials", Credentials.format)
  val name: Retrieval[Name] = SimpleRetrieval("name", Name.format)
  val dateOfBirth: Retrieval[Option[LocalDate]] = OptionalRetrieval("dateOfBirth", localDateFormat)
  val postCode: Retrieval[Option[String]] = OptionalRetrieval("postCode", Reads.StringReads)
  val email: Retrieval[Option[String]] = OptionalRetrieval("email", Reads.StringReads)
  val description: Retrieval[Option[String]] = OptionalRetrieval("description", Reads.StringReads)
  val agentInformation: Retrieval[AgentInformation] = SimpleRetrieval("agentInformation", AgentInformation.format)
  val groupIdentifier: Retrieval[Option[String]] = OptionalRetrieval("groupIdentifier", Reads.StringReads)
  val credentialRole: Retrieval[Option[CredentialRole]] = OptionalRetrieval("credentialRole", CredentialRole.format)

  val allUserDetails = credentials and name and dateOfBirth and postCode and email and
    affinityGroup and agentCode and agentInformation and credentialRole and
    description and groupIdentifier and unreadMessageCount

  val itmpName: Retrieval[ItmpName] = SimpleRetrieval("itmpName", ItmpName.format)
  val itmpDateOfBirth: Retrieval[Option[LocalDate]] = OptionalRetrieval("itmpDateOfBirth", localDateFormat)
  val itmpAddress: Retrieval[ItmpAddress] = SimpleRetrieval("itmpAddress", ItmpAddress.format)

  val allItmpUserDetails = itmpName and itmpDateOfBirth and itmpAddress
}

@deprecated("Please use uk.gov.hmrc.auth.core.retrieve.v2.Retrievals instead", "2.11.0-play-25, 2.11.0-play-26")
object Retrievals extends Retrievals