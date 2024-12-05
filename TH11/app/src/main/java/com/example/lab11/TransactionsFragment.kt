package com.example.lab11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensetracker.databinding.FragmentTransactionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionsFragment : Fragment() {
    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!

    private val transactionViewModel: TransactionViewModel by viewModels()
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        // Observe LiveData
        transactionViewModel.allTransactions.observe(viewLifecycleOwner) { transactions ->
            transactionAdapter.submitList(transactions)
        }

        // Add Transaction Button
        binding.fabAddTransaction.setOnClickListener {
            // Show dialog or navigate to add transaction screen
        }
    }

    private fun setupRecyclerView() {
        transactionAdapter = TransactionAdapter(
            onEdit = { transaction -> editTransaction(transaction) },
            onDelete = { transaction -> transactionViewModel.delete(transaction) }
        )
        binding.recyclerViewTransactions.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = transactionAdapter
        }
    }

    private fun editTransaction(transaction: Transaction) {
        // Open dialog or navigate to edit screen
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}