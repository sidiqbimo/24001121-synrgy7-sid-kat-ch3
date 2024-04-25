import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.bimobelajar.simpledictionaryrev.wordData

class WordAdapter(
//    ngambil dari dataclass
    private val wordList: List<wordData>,
    private val onItemClick: (wordData) -> Unit
) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word, parent, false)
        return ViewHolder(view)}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = wordList[position]
        holder.bind(word)}
    override fun getItemCount(): Int {
        return wordList.size }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val button: Button = itemView.findViewById(R.id.wordButton)
        fun bind(word: wordData) {
            button.text = word.value
            button.setOnClickListener {
                onItemClick(word)
            }
        }
    }
}