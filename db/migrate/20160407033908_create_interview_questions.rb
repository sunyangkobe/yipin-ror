class CreateInterviewQuestions < ActiveRecord::Migration
  def change
    create_table :interview_questions do |t|
      t.string :question
      t.string :file_name

      t.timestamps null: false
    end
  end
end
