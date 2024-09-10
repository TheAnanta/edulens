"use client";
import React, { useEffect, useState, useRef } from "react";
import { Bar } from "react-chartjs-2";
import "chart.js/auto";
import Sidebar from "@/components/Sidebar";
import Button from "@mui/material/Button";
import { downloadPDF } from "@/helper/pdfConvert";

const UniversityAnalysis = () => {
  const [data, setData] = useState(null);
  const [showAnalysis, setShowAnalysis] = useState(false); // New state to control when to show the analysis
  const pdfRef = useRef();

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch(
        "https://raw.githubusercontent.com/Chandan-6/avadaranuvu/main/dummy.json"
      );
      const result = await response.json();
      setData(result);
    };
    fetchData();
  }, []);

  const handleGenerateClick = () => {
    setShowAnalysis(true); // Show the analysis when the button is clicked
  };

  if (!data) {
    return <div>Loading...</div>; // or any other loading indicator
  }

  // Data for the bar chart
  const chartData = {
    labels: ["TLR", "RPII", "GO", "OI", "PR"],
    datasets: [
      {
        label: "Scores",
        data: [
          data.TLR?.score,
          data.RPII?.score,
          data.GO?.score,
          data.OI?.score,
          data.PR?.score,
        ],
        backgroundColor: [
          "#4CAF50",
          "#FFC107",
          "#2196F3",
          "#FF5722",
          "#9C27B0",
        ],
      },
    ],
  };

  const chartOptions = {
    scales: {
      y: {
        beginAtZero: true,
        max: 10,
      },
    },
  };

  return (
    <div>
      <Sidebar />
      <div className="flex flex-col justify-center items-center">
        <div ref={pdfRef} className="pt-24 pl-64">
          {!showAnalysis && (
            <div className="flex flex-col items-center justify-center h-[60vh]">
              <h1 className="mb-4 text-xl font-semibold">
                A Comprehensive Analysis of University
              </h1>
              <Button
                variant="contained"
                color="primary"
                onClick={handleGenerateClick}
                className="my-12 text-center"
              >
                Generate
              </Button>
            </div>
          )}

          {showAnalysis && (
            <>
              <h1 className="text-2xl font-bold my-12 w-full text-center">
                University Analysis
              </h1>

              <div className="chart-container px-48">
                <Bar data={chartData} options={chartOptions} />
              </div>

              <h1 className="text-2xl font-bold my-12 w-full text-center">
                Tabulated Data
              </h1>

              <table className="w-full text-left border-collapse my-8">
                <thead>
                  <tr>
                    <th className="border border-gray-300 px-4 py-2 bg-[var(--tertiary)]">
                      Category
                    </th>
                    <th className="border border-gray-300 px-4 py-2 bg-[var(--tertiary)]">
                      Score
                    </th>
                    <th className="border border-gray-300 px-4 py-2 bg-[var(--tertiary)]">
                      Strengths
                    </th>
                    <th className="border border-gray-300 px-4 py-2 bg-[var(--tertiary)]">
                      Weaknesses
                    </th>
                    <th className="border border-gray-300 px-4 py-2 bg-[var(--tertiary)]">
                      Recommendations
                    </th>
                  </tr>
                </thead>
                <tbody>
                  {Object.keys(data).map((key) => (
                    <tr key={key} className="odd:bg-[var(--quatnary-color)] even:bg-gray-50">
                      <td className="border border-gray-300 px-4 py-2">
                        {key}
                      </td>
                      <td className="border border-gray-300 px-4 py-2">
                        {data[key]?.score}
                      </td>
                      <td className="border border-gray-300 px-4 py-2">
                        <ul className="list-disc pl-5">
                          {data[key]?.strengths?.map((strength, index) => (
                            <li key={index}>{strength}</li>
                          )) || <li>No strengths listed</li>}
                        </ul>
                      </td>
                      <td className="border border-gray-300 px-4 py-2">
                        <ul className="list-disc pl-5">
                          {data[key]?.weaknesses?.map((weakness, index) => (
                            <li key={index}>{weakness}</li>
                          )) || <li>No weaknesses listed</li>}
                        </ul>
                      </td>
                      <td className="border border-gray-300 px-4 py-2">
                        <ul className="list-disc pl-5">
                          {data[key]?.recommendations?.map(
                            (recommendation, index) => (
                              <li key={index}>{recommendation}</li>
                            )
                          ) || <li>No recommendations listed</li>}
                        </ul>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </>
          )}
        </div>
        {showAnalysis && (
          <Button
            onClick={() => {
              // Remove the padding
              pdfRef.current.classList.remove("pl-64");
              pdfRef.current.classList.add("px-10");

              downloadPDF(pdfRef);

              // Re-add the padding
              setTimeout(() => {
                pdfRef.current.classList.add("pl-64");
              }, 100);
            }}
            variant="contained"
            className="w-fit mx-auto"
          >
            Download
          </Button>
        )}
      </div>
    </div>
  );
};

export default UniversityAnalysis;
