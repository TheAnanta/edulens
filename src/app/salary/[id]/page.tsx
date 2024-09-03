import Sidebar from '@/components/Sidebar';
import React from 'react';

function App(props: { params: { id: string } }) {
    const scheduleData = [
        { year: 2024, month: 'August', grossAmount: 46000, deductionAmount: 8000, netAmount: 38000 },
        { year: 2024, month: 'August', grossAmount: 46000, deductionAmount: 8000, netAmount: 38000 },
        { year: 2024, month: 'August', grossAmount: 46000, deductionAmount: 8000, netAmount: 38000 },
        { year: 2024, month: 'August', grossAmount: 46000, deductionAmount: 8000, netAmount: 38000 },
        { year: 2024, month: 'August', grossAmount: 46000, deductionAmount: 8000, netAmount: 38000 },
        { year: 2024, month: 'August', grossAmount: 46000, deductionAmount: 8000, netAmount: 38000 },
        { year: 2024, month: 'August', grossAmount: 46000, deductionAmount: 8000, netAmount: 38000 },
    ];

    return (
        <div className="p-8 flex">
            <Sidebar />
            <div className="w-full overflow-hidden rounded-lg mt-24 space-y-10">
                <p className="w-full text-center text-4xl font-bold">Salary Portal</p>
                <table className="w-full bg-blue-700 text-white">
                    <thead>
                        <tr>
                            <th className="head">Year</th>
                            <th className="head">Month</th>
                            <th className="head">Gross Amount</th>
                            <th className="head">Deduction Amount</th>
                            <th className="head">Net Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        {scheduleData.map((item, index) => (
                            <tr key={index} className="even:bg-blue-700 odd:bg-blue-600">
                                <td>{item.year}</td>
                                <td>{item.month}</td>
                                <td>{item.grossAmount}</td>
                                <td>{item.deductionAmount}</td>
                                <td>{item.netAmount}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default App;
