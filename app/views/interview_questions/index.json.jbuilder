json.array!(@interview_questions) do |interview_question|
  json.extract! interview_question, :id, :question, :file_name
  json.url interview_question_url(interview_question, format: :json)
end
