package api

/**
 * Created by sai on 13/09/2015.
 */
case class Frequency(vocabulary: Vocabulary) {
  def termFrequency(term: Term, document: Document) = document.allTerms.count(_.equals(term))

  def inverseDocumentFrequency(term: Term) = vocabulary.documents.flatMap(doc => doc.allTerms.distinct).count(_.equals(term))
}
